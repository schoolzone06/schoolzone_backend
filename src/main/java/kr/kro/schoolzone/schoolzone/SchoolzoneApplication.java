package kr.kro.schoolzone.schoolzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchoolzoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolzoneApplication.class, args);
    }

}
