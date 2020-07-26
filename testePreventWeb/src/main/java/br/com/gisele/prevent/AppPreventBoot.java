package br.com.gisele.prevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan("br.com.gisele")
@EnableSwagger2
public class AppPreventBoot {
	
    public static void main( String[] args ) {
        SpringApplication.run(AppPreventBoot.class, args);
    }
    
}
