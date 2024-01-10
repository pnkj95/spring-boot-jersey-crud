package com.boot.jersey.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.boot.jersey.controller.UserResource;

import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/boot-jersey")
public class JerseyConfiguration extends ResourceConfig {
 public JerseyConfiguration() {
  //register(UserResource.class);
  packages("com.boot.jersey.controller");
  register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
    Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
 }
}
