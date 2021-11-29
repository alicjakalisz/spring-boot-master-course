package com.example.demo.infoapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// way of taking application properties starting from info.app and bringing them into java class. Requires dependency in pom.xml -processor
@Configuration
@ConfigurationProperties(prefix = "info.app") // look at actuator settings in appplication.properties
@Data
public class InfoApp {
    private String name;
    private String description;
    private String version;
// CLEANING WITH LOMBOK

    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "InfoApp{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                '}';
    } */
}
