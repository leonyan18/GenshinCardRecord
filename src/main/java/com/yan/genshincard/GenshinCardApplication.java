package com.yan.genshincard;

import com.yan.genshincard.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenshinCardApplication {
    @Autowired
    private RecordService recordService;

    public static void main(String[] args) {
        SpringApplication.run(GenshinCardApplication.class, args);
    }

}
