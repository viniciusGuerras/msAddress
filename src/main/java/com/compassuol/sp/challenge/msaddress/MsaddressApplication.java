package com.compassuol.sp.challenge.msaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsaddressApplication{

	public static void main(String[] args) {
		SpringApplication.run(MsaddressApplication.class, args);
	}

}
