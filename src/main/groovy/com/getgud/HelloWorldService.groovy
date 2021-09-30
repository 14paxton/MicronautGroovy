package com.getgud

import io.micronaut.context.annotation.Property
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
class HelloWorldService {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldService.class)
    
   @Property(name = "hello.service.greeting", defaultValue = "default")
   private String greeting;

    def sayHi(){
        return greeting
    }
    
    @EventListener
    static void onStartup(StartupEvent startupEvent){
        LOG.debug("Startup: {}" , HelloWorldService.class.getSimpleName())
    }
    
}
