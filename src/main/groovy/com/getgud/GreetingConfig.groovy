package com.getgud

import io.micronaut.context.annotation.ConfigurationInject
import io.micronaut.context.annotation.ConfigurationProperties

import javax.validation.constraints.NotBlank

@ConfigurationProperties('hello.config.greeting')
class GreetingConfig {
    private final String de;
    private final String en;
    
    @ConfigurationInject
    GreetingConfig(@NotBlank final String de, @NotBlank final String en){
        this.de = de
        this.en = en
    }
    
    public def getDe(){
        de
    }
    
    public def getEn(){
        en
    }
    
}
