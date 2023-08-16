package com.springboot.catalog.service.impl;

import com.springboot.catalog.config.ApplicationProperties;
import com.springboot.catalog.config.CloudProperties;
import com.springboot.catalog.service.GreetingService;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class GreetingServiceImpl implements GreetingService {

    private ApplicationProperties applicationProperties;

    private CloudProperties cloudProperties;

    public GreetingServiceImpl(ApplicationProperties applicationProperties, CloudProperties cloudProperties) {
        this.applicationProperties = applicationProperties;
        this.cloudProperties = cloudProperties;
    }

    @Override
    public String sayGreeting() {
        System.out.println(cloudProperties.getApiKey());
        TimeZone tz = TimeZone.getTimeZone(applicationProperties.getTimeZone());
        return applicationProperties.getSayGreeting() + ", timezone : " + tz.getDisplayName() + ", currency : " + applicationProperties.getCurrency() + " API key : " + cloudProperties.getApiKey();
    }
}
