package com.example.zipkinservice3;


import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@WebService
public class ZipkinWebService{
	private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(ZipkinWebService.class.getName());
		
	/*@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}*/

	
	@Autowired
	RestTemplate restTemplate;
	


	@WebMethod
	public String sayHello(String name) {
		LOG.info("start");
		 String response = (String) restTemplate.exchange("http://localhost:8082/zipkin2", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	        }).getBody();
		
	//	LOG.info("finsh");
		return "Hello, " + name;
	}
}