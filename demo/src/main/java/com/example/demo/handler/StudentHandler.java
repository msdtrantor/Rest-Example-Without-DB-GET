package com.example.demo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentHandler {

	@Autowired
	StudentDAO studentDAO;

	public Mono<ServerResponse> loadStudent(ServerRequest request) {
		Flux<Student> studentListRouter = studentDAO.getStudentListRouter();

		return ServerResponse
				.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(studentListRouter, Student.class);
	}
}
