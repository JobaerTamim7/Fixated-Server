package org.fixated;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "org.fixated")
public class Server {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Server.class,args);
        System.out.println("Running ..... ");
    }
}
