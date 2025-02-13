package com.example.springbootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String home() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
@GetMapping("/ip")
public String getIpAddress() {
    try {
        return java.net.InetAddress.getLocalHost().getHostAddress();
    } catch (java.net.UnknownHostException e) {
        return "Could not determine IP address";
    }
}