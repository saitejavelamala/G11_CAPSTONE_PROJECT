package com.wipro.doconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/*@Author:Arpit Verma
 * Modified Date: 26-08-2022
 * Description: Main class
 */
@SpringBootApplication
public class DoConnectApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(DoConnectApplication.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}