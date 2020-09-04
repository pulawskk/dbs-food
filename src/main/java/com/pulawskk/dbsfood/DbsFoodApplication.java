package com.pulawskk.dbsfood;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbsFoodApplication {

    public static void main(String[] args) {
        System.out.println("spring ENV datasource before: " + System.getenv("SPRING_DATASOURCE_URL"));
        System.out.println("test ENV before: " + System.getenv("COM_PULAWSKK_TEST"));
        System.out.println("property before: " + System.getProperty("spring.datasource.url"));
        System.out.println("property test before: " + System.getProperty("com.pulawskk.test"));
        SpringApplication.run(DbsFoodApplication.class, args);
        System.out.println("spring ENV datasource after: " + System.getenv("SPRING_DATASOURCE_URL"));
        System.out.println("property after: " + System.getProperty("spring.datasource.url"));
        System.out.println("test ENV after: " + System.getenv("COM_PULAWSKK_TEST"));
        System.out.println("property test after: " + System.getProperty("com.pulawskk.test"));
    }

}
