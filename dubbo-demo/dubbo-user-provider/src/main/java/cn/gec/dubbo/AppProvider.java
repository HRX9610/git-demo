package cn.gec.dubbo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AppProvider {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AppProvider.class).web(WebApplicationType.NONE).run(args);
    }
}
