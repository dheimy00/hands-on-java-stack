package {{ global_computed_inputs.base_package }};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class {{ global_computed_inputs.application_name }}Application {

    public static void main(String[] args) {
        SpringApplication.run({{ global_computed_inputs.application_name }}Application.class, args);
    }

}
