package org.example.briefservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "org.example.briefservice.client")
public class BriefServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BriefServiceApplication.class, args);
    }

}
