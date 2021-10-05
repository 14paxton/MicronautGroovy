package com.bpaxton.broker

import com.bpaxton.broker.model.Symbol
import com.bpaxton.broker.store.InMemoryStore
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller("/markets")
class MarketsController {
//    @Inject
//    InMemoryStore store
    
    private final InMemoryStore store

    MarketsController(final InMemoryStore store) {
        this.store = store
    }

    
    @Get(uri="/")
    List<Symbol> all() {
        return store.getAllSymbols()
    }
    
    
}