package com.gajavalli.server;



import java.util.stream.Stream;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.gajavalli.server.model.ServerModel;
import com.gajavalli.server.repository.ServerRepository;


@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	
    @Bean
    ApplicationRunner init(ServerRepository repository) {
        return args -> {
            Stream.of( 
            		new ServerModel(101, "javatechie", "password", "javatechie@gmail.com"),
                    new ServerModel(102, "user1", "pwd1", "user1@gmail.com"),
                    new ServerModel(103, "user2", "pwd2", "user2@gmail.com"),
                    new ServerModel(104, "user3", "pwd3", "user3@gmail.com")).forEach(initModel -> {
                ServerModel model = new ServerModel();
                model.setUrl(initModel.getUrl());
                model.setUsername(initModel.getUsername());
                model.setPassword(initModel.getPassword());
                repository.save(model);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
