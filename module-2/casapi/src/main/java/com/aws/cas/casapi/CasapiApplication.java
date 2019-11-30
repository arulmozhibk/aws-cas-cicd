package com.aws.cas.casapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CasapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CasUserService casUserService) {
		return args -> {
			String jsonFile = "/json/cas-user-response.json";
			ObjectMapper jsonMapper = new ObjectMapper();
			jsonMapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false );
			InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFile);
			System.out.println( "input stream "+inputStream.toString());

			try {
				CasUser allusers = jsonMapper.readValue(inputStream, CasUser.class);

				System.out.println("allusers "+allusers);

				casUserService.save(allusers);
				CasUser cu=new CasUser();
				cu=casUserService.getUserList();
				System.out.println( "Saved list "+cu );
			}
			catch (IOException e) {
				System.out.println("Unable to get user list : " + e.getMessage()+" :::: "+e.getCause());
			}
		};
	}

}
