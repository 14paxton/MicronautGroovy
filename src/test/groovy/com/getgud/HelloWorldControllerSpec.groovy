package com.getgud

import io.micronaut.http.client.annotation.Client
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
class HelloWorldControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    HttpClient client

    void "test index"() {
        given:
        HttpResponse response = client.toBlocking().exchange("/hello")
        def result = client.toBlocking().retrieve("/hello")

        expect:
        response.status == HttpStatus.OK
        result == "what up hommie?"
    }


    void "test en"() {
        given:
        HttpResponse response = client.toBlocking().exchange("/hello/en")
        def result = client.toBlocking().retrieve("/hello/en")

        expect:
        response.status == HttpStatus.OK
        result == "english"
    }

    void "test de"() {
        given:
        HttpResponse response = client.toBlocking().exchange("/hello/de")
        def result = client.toBlocking().retrieve("/hello/de")

        expect:
        response.status == HttpStatus.OK
        result == "german"
    }
}
