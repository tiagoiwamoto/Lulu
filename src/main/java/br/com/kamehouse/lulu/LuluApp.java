package br.com.kamehouse.lulu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LuluApp {

    public static void main(String[] args) {
        SpringApplication.run(LuluApp.class, args);
    }

}
