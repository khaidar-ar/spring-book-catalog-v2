package com.springboot.catalog.web;

import com.springboot.catalog.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
    Logger logger = LoggerFactory.getLogger(HelloResource.class);
    private GreetingService greetingService;

    @Autowired
    public HelloResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        logger.trace("this is log trace");
        logger.debug("this is log debug");
        logger.info("this is log info");
        logger.error("this is log error");
        logger.warn("this is log warn");
        return greetingService.sayGreeting();
    }

}
