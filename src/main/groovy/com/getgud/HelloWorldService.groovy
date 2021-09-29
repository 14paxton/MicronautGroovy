package com.getgud

import io.micronaut.context.annotation.Property
import jakarta.inject.Singleton

@Singleton
class HelloWorldService {
    
   @Property(name = "hello.service.greeting", defaultValue = "default")
   private String greeting;

    def sayHi(){
        return greeting
    }
    
    
}
