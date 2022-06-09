package com.natwest.PortfolioMicroservice.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.natwest.PortfolioMicroservice.controller.PortfolioController;
import com.natwest.PortfolioMicroservice.model.PortFolio;
import com.natwest.PortfolioMicroservice.model.Trade;
import com.natwest.PortfolioMicroservice.model.User;
import com.natwest.PortfolioMicroservice.repository.PortFolioRepo;
import com.natwest.PortfolioMicroservice.repository.UserRepo;

@SpringBootTest
public class PortfolioServiceTest {
	MockMvc mockmvcobj;

	@Mock
	UserRepo userrepo;
	
	@Mock
	PortFolioRepo portrepo;

	@MockBean
	PortFolioService portservice;

	PortFolio portfolio;
	User user;
	Trade trade1; 
	
    Optional<User> user_check;
    Optional<PortFolio> portfolio_check;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() throws Exception 
    {
    	MockitoAnnotations.initMocks(this);
		
		user = new User();
		user.setUserid("shubham456@email.com");

		portfolio=new PortFolio();
		portfolio.setId("1001");
		portfolio.setDescription("green investment");
		portfolio.setName("Green123");
		
		trade1= new Trade();
		trade1.setId("23");
		trade1.setPrice(1800.0);
		trade1.setQuantity(20);
		trade1.setStock("infosys");
		trade1.setBuySell("buy");   
    }

}
