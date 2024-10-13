package com.example.rksp4client.controllers;

import com.example.rksp4client.entity.MatchStats;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")

public class RequestStreamController {
    private final RSocketRequester rSocketRequester;
    @Autowired
    public RequestStreamController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }
    @GetMapping
    public Publisher<MatchStats> getStats() {
        return rSocketRequester
                .route("getStats")
                .data(new MatchStats())
                .retrieveFlux(MatchStats.class);
    }

}
