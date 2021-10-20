package com.BusWorkshop;

import com.BusWorkshop.model.MaintenanceType;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//@EnableWebMvc
public class Application {
    public static void main(String[] args) {
        //var changeTire = MaintenanceType.ENGINE_REBUILD.getResponse();
        //System.out.println(changeTire);
        SpringApplication.run(Application.class, args);

    }
}
