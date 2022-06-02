package com.example.demo.dao;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.example.demo.entity.Student;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class StudentDAO {

	public Flux<Student> getStudentListRouter() {
		Logger logger = LoggerFactory.getLogger(getClass());
		return Flux.range(1, 5).delayElements(Duration.ofSeconds(1))
				.doOnNext(integer -> logger.warn("Processing Count =" + integer))
				.map(integer -> new Student(integer, "Student " + integer));
	}
}
