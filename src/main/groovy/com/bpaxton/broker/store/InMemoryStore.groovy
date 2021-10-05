package com.bpaxton.broker.store

import com.bpaxton.broker.model.Symbol
import jakarta.inject.Singleton

import java.util.stream.Collectors
import java.util.stream.Stream


@Singleton
class InMemoryStore {
    private final List<Symbol> symbols

    InMemoryStore() {
        def x  = Stream.of("AAPL", "AMZN", "FB", "GOOG", "MSFT", "NFLX", "TSLA")
                             .map({new Symbol(value: it)})
                             .collect(Collectors.toList())
        
        this.symbols = x
    }

    List<Symbol> getAllSymbols() {
        return symbols
    }
}
