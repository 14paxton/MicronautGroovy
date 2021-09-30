package com.getgud

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class)
    
    
    static void main(String[] args) {
        final ApplicationContext context = Micronaut.run(Application.class)
        final HelloWorldService service = context.getBean(HelloWorldService.class)
        LOG.info(service.sayHi())
    }
}
