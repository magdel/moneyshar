package ru.moneyshar.site;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoneysharApplication {
    private static final Logger logger = LoggerFactory.getLogger(MoneysharApplication.class);

    public static void main(String[] args) {
        logger.info("Entering..");
        System.out.println("Starting..");
        SpringApplication.run(MoneysharApplication.class, args);
        System.out.println("Started");
    }
}
