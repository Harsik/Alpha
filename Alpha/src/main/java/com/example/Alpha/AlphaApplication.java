package com.example.Alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = { AlphaApplication.class, Jsr310JpaConverters.class })
public class AlphaApplication {

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    // 아직 안된다 
    // The bean 'userRepository', defined in null, could not be registered. A
    // bean with that name has already been defined in null and overriding is
    // disabled.
    // 해결해야됨
    public static void main(String[] args) {
        SpringApplication.run(AlphaApplication.class, args);
    }
}