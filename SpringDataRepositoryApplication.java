package com.repository.SpringDataRepository;

import com.repository.SpringDataRepository.Entity.Person;
import com.repository.SpringDataRepository.Service.PeopleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class SpringDataRepositoryApplication
{
	static RestTemplate restTemplate=new RestTemplate();
	static String baseUrl="http://localhost:8080/springData/";
	public static void main(String[] args)
	{
		SpringApplication.run(SpringDataRepositoryApplication.class, args);
		userExchageMethodOfRestTemplate();
	}

	private static void userExchageMethodOfRestTemplate()
	{
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity=new HttpEntity<>(headers);

		ResponseEntity<String> responseEntity=restTemplate.exchange(baseUrl+"findByIdCrud/654",
				HttpMethod.GET,requestEntity, String.class);
		HttpStatus statusCode= (HttpStatus) responseEntity.getStatusCode();
		System.out.println("response status code is="+statusCode);
		String user=responseEntity.getBody();
		System.out.println("response body is="+user);
		HttpHeaders responseHeaders=responseEntity.getHeaders();
		System.out.println("Response headers is="+responseHeaders);
	}


}

