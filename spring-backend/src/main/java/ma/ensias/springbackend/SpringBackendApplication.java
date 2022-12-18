package ma.ensias.springbackend;

import ma.ensias.springbackend.module.Module;
import ma.ensias.springbackend.service.ModuleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class SpringBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBackendApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ModuleService moduleService) {
        return args -> {
            moduleService.addModule( new Module(null , "JSP" , "Java Server Page")) ;
            moduleService.addModule( new Module(null , "JEE" , "Java Enterprise Edition")) ;
            moduleService.addModule( new Module(null , "JSE" , "Java Standard Edition")) ;
        } ;
    }
}
