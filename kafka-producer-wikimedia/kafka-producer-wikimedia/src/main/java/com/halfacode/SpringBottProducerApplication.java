package com.halfacode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBottProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBottProducerApplication.class);
    }

    @Autowired
    private WikimediaChangeProcedure wikimediaChangeProcedure;

    @Override
    public void run(String... args) throws Exception {
     wikimediaChangeProcedure.sendMessage();
    }
}
