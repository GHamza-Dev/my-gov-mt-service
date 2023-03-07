package io.flat.mtservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MtServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MtServiceApplication.class, args);
    }

}
