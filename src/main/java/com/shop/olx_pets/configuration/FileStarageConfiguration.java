package com.shop.olx_pets.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
@Slf4j
public class FileStarageConfiguration {

    @Bean(name = "basePath")
    public String basePath() {
//        File baseDir = new File("uploads/user");//?????????????????

//        if (!baseDir.exists()) {
//            log.info("uploads is created: {}", baseDir.mkdir());
//        }
        String[] strings = {
                "uploads",
                "user"
        };

        return createDir(strings);

    }

    @Bean(name = "advertisementPhotoPath")
    public String advertisementPhotoPath() {
//        File baseDir = new File("uploads/advertisement");
//        if (!baseDir.exists()) {
//            baseDir.mkdir();
//        }
//        log.info("advertisementPhotoPath created: ", baseDir.getAbsolutePath());
//        return baseDir.getAbsolutePath();

        String[] strings = {
                "uploads",
                "advertisement"
        };

        return createDir(strings);
    }

    private String createDir(String[] strings){
        log.info("Creating dir");

        File baseDir = null;
        String s = "";
        for (int i = 0; i < strings.length; i++) {
            if (i == 0){
                s = s + strings[i];
            } else {
                s = s + "/" + strings[i];
            }
            baseDir = new File(s);
            if (!baseDir.exists()){

                if (Files.isDirectory(Paths.get(s))) {
//                    log.info("dir is created: {}", baseDir.mkdir());
                }


            }
        }

        log.info("Path created: ", baseDir.getAbsolutePath());
        return baseDir.getAbsolutePath();
    }
}
