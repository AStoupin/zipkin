package com.example.zipkinservice3;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
/*import org.apache.cxf.Bus;
*/
import org.apache.cxf.jaxws.EndpointImpl;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ZipkinService3Application {
//	private static final Logger LOG = Logger.getLogger(ZipkinService3Application.class.getName());

	public static void main(String[] args) {
		//LOG.info("start0");
	
		SpringApplication.run(ZipkinService3Application.class, args);
	}
}

@Configuration
class ZipkinService3Config{
//	private static final Logger LOG = Logger.getLogger(ZipkinService3Config.class.getName());

	@Autowired
	private Bus bus;

/*	@Autowired
	private ApplicationContext applicationContext;*/
	
	@Bean
	ZipkinWebService zipkinWebService() {
		return new ZipkinWebService();
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}	
	
	@Bean
	public Endpoint getEndpoint() {
//		LOG.info("start2");
		System.out.println("start2");
		//ZipkinWebService zipkinWebService = new ZipkinWebService();
		Endpoint endpoint = new EndpointImpl(bus, zipkinWebService());
		endpoint.publish("/http-test-ws");

		return endpoint;
	} 		
		
}

