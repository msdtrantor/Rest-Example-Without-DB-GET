package com.example.demo.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.handler.StudentHandler;

@Configuration
public class StudentRouter {

	@Bean
	public RouterFunction<ServerResponse> routerFunction(StudentHandler studentHandler) {
		return RouterFunctions.route().GET("/loadStudents", studentHandler::loadStudent).build();
	}
}
