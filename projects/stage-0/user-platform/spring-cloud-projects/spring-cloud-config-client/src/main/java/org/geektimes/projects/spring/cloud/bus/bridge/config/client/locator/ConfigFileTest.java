package org.geektimes.projects.spring.cloud.bus.bridge.config.client.locator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ConfigFileTest {
    @Value("${my.name}")
    private String myName;

    @Value("${my.age}")
    private int myAge;

    @Autowired
    private ApplicationContext context;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            while (true) {
                Thread.sleep(1000);
                System.out.printf("my.name = %s, my.age = %d,default.message = %s %n", myName, myAge, context.getEnvironment().getProperty("default.properties"));
            }
        };
    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerInitialized(WebServerInitializedEvent event) {
        WebServer webServer = event.getWebServer();
        System.out.println("当前 Web 服务器端口：" + webServer.getPort());
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigFileTest.class, args);
    }
}
