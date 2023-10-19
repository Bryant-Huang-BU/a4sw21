package com.example.assignment4_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
@SpringBootApplication

public class Assignment4DemoApplication implements CommandLineRunner {
	private static final Logger log =
			LoggerFactory.getLogger(Assignment4DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(Assignment4DemoApplication.class, args);
	}
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void run(String... strings) throws Exception {
		log.info("Creating table");
		jdbcTemplate.execute("DROP TABLE random_data IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE random_data(" + "id SERIAL, data VARCHAR(255))");
	}
}