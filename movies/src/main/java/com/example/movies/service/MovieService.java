package com.example.movies.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieService {
    
	private final String apiKey = "dcda07a9";
	private String baseUrl = "http://www.omdbapi.com";
	private final  RestTemplate restTemplate ;
	public String getFullUrl(String movieName)
	{
		return baseUrl + "/?t=" + movieName +"&apikey=" + apiKey; 
	}
	
	 public MovieService(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	    }
	

	
	public String getMovie(String movieName) {

		  	ResponseEntity<String> resp = 
			          restTemplate.getForEntity(getFullUrl(movieName),String.class);
		  	    
				return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
		    }
	}

  
	
	
	
	

