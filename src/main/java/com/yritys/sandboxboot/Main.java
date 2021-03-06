/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.sandboxboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Tommi
 */
@SpringBootApplication
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean(name="Tulostaja")
    public CommandLineRunner commandLinerunner(ApplicationContext ctx) {
        return args -> {
            
            String[] beanNames = ctx.getBeanDefinitionNames();
            for(String bean : beanNames){
                System.out.println(bean);
            }
        };
    }
}
