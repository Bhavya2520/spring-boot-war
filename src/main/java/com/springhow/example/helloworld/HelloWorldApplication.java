// package com.springhow.example.helloworld;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @SpringBootApplication
// public class HelloWorldApplication extends SpringBootServletInitializer {

//     @Override
//     protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//         return application.sources(HelloWorldApplication.class);
//     }

//     public static void main(String[] args) {
//         SpringApplication.run(HelloWorldApplication.class);
//     }


//     @RequestMapping("/")
//     String helloWorld() {
//         return "Hello World!from BHAVYA edited at 11:37";
//     }

// }

package com.springhow.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@SpringBootApplication
public class HelloWorldApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HelloWorldApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class);
    }

    // Main endpoint
    @RequestMapping("/")
    public String home() throws Exception {

        String hostname = InetAddress.getLocalHost().getHostName();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return "<h1>🚀 Spring Boot Application Deployed via Jenkins</h1>"
                + "<p><b>Developer:</b> Bhavya</p>"
                + "<p><b>Server Hostname:</b> " + hostname + "</p>"
                + "<p><b>Server IP:</b> " + ip + "</p>"
                + "<p><b>Current Time:</b> " + time + "</p>"
                + "<p><b>Status:</b> ✅ Application Running Successfully</p>";
    }

    // Health check endpoint (used in real DevOps monitoring)
    @RequestMapping("/health")
    public String health() {
        return "{ \"status\": \"UP\", \"application\": \"hello-world\", \"deployedBy\": \"Jenkins\" }";
    }

    // Version endpoint
    @RequestMapping("/version")
    public String version() {
        return "Version 2.0 - Deployed via Jenkins Pipeline at " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // DevOps test endpoint
    @RequestMapping("/devops")
    public String devops() {
        return "🔥 Congratulations Bhavya! Your Jenkins → Tomcat → VM pipeline is working perfectly!";
    }

}
