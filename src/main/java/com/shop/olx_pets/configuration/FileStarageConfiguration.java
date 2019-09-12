package com.shop.olx_pets.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
@Slf4j
public class FileStarageConfiguration {

    @Bean(name = "basePath")
    public String basePath() {
        File baseDir = new File("uploads");
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }
        log.info("BasePath created: ", baseDir.getAbsolutePath());
        return baseDir.getAbsolutePath();
    }
}
