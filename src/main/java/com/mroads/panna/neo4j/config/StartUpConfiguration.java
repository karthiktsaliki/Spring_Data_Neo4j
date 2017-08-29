package com.mroads.panna.neo4j.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication
@ComponentScan({"com.mroads.*"})
@EntityScan({"com.mroads.panna.neo4j.model"})
@EnableNeo4jRepositories("com.mroads.panna.neo4j.repository")
public class StartUpConfiguration {
	public static void main(String[] args) {
		SpringApplication.run(StartUpConfiguration.class, args);
	}
}
