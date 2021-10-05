package com.bpaxton.broker

import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.rxjava3.http.client.Rx3HttpClient
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Shared

import jakarta.inject.Inject

@MicronautTest
class MarketsControllerSpec extends Specification {
//    @Inject
//    EmbeddedApplication application

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    HttpClient client
    
//    @Inject
//    @Client("/")Rx3HttpClient client

    
    
//    void "test index"() {
//        expect:
//        application.isRunning()
//    }
    
    void "returnsListOfMarkets"(){
        when:
        final List result = client.toBlocking().retrieve("/markets", List.class)
        then:
        result.size() == 7
    }
}
