package com.natwest.PortfolioMicroservice.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natwest.PortfolioMicroservice.exceptions.UserAlreadyPresentException;
import com.natwest.PortfolioMicroservice.model.PortFolio;
import com.natwest.PortfolioMicroservice.model.Trade;
import com.natwest.PortfolioMicroservice.model.User;
import com.natwest.PortfolioMicroservice.repository.PortFolioRepo;
import com.natwest.PortfolioMicroservice.repository.UserRepo;
import com.natwest.PortfolioMicroservice.services.PortFolioService;


@SpringBootTest
public class PortfolioControllerTest {
	MockMvc mockmvcobj;
	
	@MockBean
	PortFolioService portservice;
	
	@InjectMocks
	PortfolioController pcontroller;
	
	@Autowired
	UserRepo userrepo;

	PortFolio portfolio;
	User user;
	Trade trade1;
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup() throws UserAlreadyPresentException
	{
		MockitoAnnotations.initMocks(this);
		
		mockmvcobj=MockMvcBuilders.standaloneSetup(pcontroller).build();
		
		user = new User();
		user.setUserid("shubahm@email.com");
		portservice.addUser(user);

		portfolio=new PortFolio();
		portfolio.setId("100");
		portfolio.setDescription("grren investment");
		portfolio.setName("Green123");
		
		trade1= new Trade();
		trade1.setId("23");
		trade1.setPrice(1800.0);
		trade1.setQuantity(20);
		trade1.setStock("infosys");
		trade1.setBuySell("buy");
	}
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(pcontroller).isNotNull();
	}

	@Test
	public void addportfolioandreturnobjectsuccess() throws Exception
	{
		
		PortFolio portret = new PortFolio();
		Mockito.when(portservice.createPortfolio(portfolio, "shubham@email.com")).thenReturn(portret);
		System.out.println("hello: " + portret.getId() + portret.getDescription());
		System.out.println(portret.getTimestamp());
		
		mockmvcobj.perform(MockMvcRequestBuilders.post("/tradeStocks/shubham@email.com/Green/"));
	}


	public String convertObjtoString(Object obj) throws JsonProcessingException
	{
		ObjectMapper objmap=new ObjectMapper();
		String result=objmap.writeValueAsString(obj);
			return result;
	}
	
	
	
	@Test
	public void testAddPortfolio() throws Exception
	{
		Mockito.when(portservice.createPortfolio(portfolio, user.getUserid())).thenReturn(portfolio);
		mockmvcobj.perform(MockMvcRequestBuilders.post("/api/portfolio/createportfolio/"+user.getUserid())
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertObjtoString(portfolio)))
				.andExpect(MockMvcResultMatchers.status()
				.isCreated());
	}
	
	
	@Test
	public void testviewPortfolio() throws Exception
	{
		List<PortFolio> bank_list = null;
		Mockito.when(portservice.viewAllPortFolios(user.getUserid())).thenReturn(bank_list);
		mockmvcobj.perform(MockMvcRequestBuilders.get("/api/portfolio/viewallportfolios/"+user.getUserid())
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertObjtoString(portfolio)))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	public void testdeletePortfolio() throws Exception
	{
		Mockito.when(portservice.deletePortfolio(user.getUserid(), portfolio.getName())).thenReturn(true);
		mockmvcobj.perform(MockMvcRequestBuilders.delete("/api/portfolio/deleteportfolio/"+user.getUserid()+"/"+portfolio.getName())
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertObjtoString(portfolio)))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	public void tradeStocksInPortfolio() throws Exception
	{
		Trade currtrade = new Trade();
		PortFolio portret = new PortFolio();
		portret.setId("qwert");;
		portret.setName("port1");
		portret.setDescription("desc1");
		portservice.createPortfolio(portret, user.getUserid());
		Mockito.when(portservice.tradeStocks(user.getUserid(), portret.getName(), trade1)).thenReturn(currtrade);
		mockmvcobj.perform(MockMvcRequestBuilders.post("/api/portfolio/tradeStocks/"+user.getUserid()+"/"+portret.getName())
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertObjtoString(trade1)))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
