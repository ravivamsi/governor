package com.servec.governor;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jcraft.jsch.JSchException;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) throws JSchException, IOException {
		SpringApplication.run(SpringbootApplication.class, args);

	}

}
