package net.setlog.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class SpringWebfluxMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxMongoApplication.class, args);
    }

}
