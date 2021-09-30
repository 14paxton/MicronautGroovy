package com.getgud

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller("{hello.controller.path}")
class HelloWorldController {
    private HelloWorldService helloWorldService
    private final GreetingConfig config

    HelloWorldController(final HelloWorldService helloWorldService, final GreetingConfig config) {
        this.helloWorldService = helloWorldService
        this.config = config
    }

    @Get(uri = "/", produces = "text/plain")
    public String index() {
        return helloWorldService.sayHi()
    }


    @Get("/de")
    public String greetInGerman() {
        return config.getDe()
    }

    @Get("/en")
    public String greetInEnglish() {
        return config.getEn()
    }


}