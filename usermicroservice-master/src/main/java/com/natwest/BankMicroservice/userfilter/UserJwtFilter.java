package com.natwest.BankMicroservice.userfilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class UserJwtFilter extends GenericFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httprequest=(HttpServletRequest)request;
		HttpServletResponse httpresponse=(HttpServletResponse)response;
		
		httpresponse.setHeader("Access-Control-Allow-Origin",httprequest.getHeader("origin"));
		httpresponse.setHeader("Access-Control-Allow-Methods", "POST,PUT,DELETE,GET,OPTIONS");
		httpresponse.setHeader("Access-Control-Allow-Credential","true");
		httpresponse.setHeader("Access-Control-Allow-Headers", "*");
		//if(httprequest.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name()))

		//{
			chain.doFilter(httprequest, httpresponse);
			
		}
	}
	/*
		else
		{
			String headerinfo=httprequest.getHeader("Authorization");
			if( (headerinfo==null) || (!headerinfo.startsWith("Bearer")))
					{
				 throw new ServletException("JWT token is missing");
					}
			System.out.println(headerinfo);
			String mytoken=headerinfo.substring(7);
			System.out.println("token received");
		
			
			try
			{
			  JwtParser myparser=Jwts.parser().setSigningKey("natwestkey");
			  Jwt jobj=myparser.parse(mytoken);
			  Claims claim= (Claims)jobj.getBody();
			  System.out.println(claim.getSubject());
				
			}
			catch(Exception e)
			{
				throw new ServletException("Jwt Key invalide" + e.getMessage());
			}
			
			
		
			chain.doFilter(httprequest, httpresponse);
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}

*/