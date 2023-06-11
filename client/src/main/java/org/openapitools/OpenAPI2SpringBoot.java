package org.openapitools;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.Serial;

@SpringBootApplication
@ComponentScan(basePackages = {"org.openapitools", "minicloud.client", "org.openapitools.configuration"})
public class OpenAPI2SpringBoot implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplication(OpenAPI2SpringBoot.class).run(args);
    }

    @Override
    public void run(String... args) {
        if (args.length > 0 && args[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    @Bean
    public WebMvcConfigurer webConfigurer() {
        return new WebMvcConfigurer() {
            /*
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("Content-Type");
            }
            */
        };
    }

    static class ExitException extends RuntimeException implements ExitCodeGenerator {
        @Serial
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }
    }
}
