package com.springboot.catalog.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

    private String sayGreeting;

    private String timeZone;

    private String currency;

    public String getSayGreeting() {
        return sayGreeting;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getCurrency() {
        return currency;
    }

    public void setSayGreeting(String sayGreeting) {
        this.sayGreeting = sayGreeting;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
