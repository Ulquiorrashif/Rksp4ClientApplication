package com.example.rksp4client.controllers;

import com.example.rksp4client.entity.MatchStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/stats")

public class RequestResponseController {
    private final RSocketRequester rSocketRequester;
    @Autowired
    public RequestResponseController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }
    @GetMapping("/{id}")
    public Mono<MatchStats> getCat(@PathVariable Long id) {
        return rSocketRequester
                .route("getStat")
                .data(id)
                .retrieveMono(MatchStats.class);
    }
    @PostMapping
    public Mono<MatchStats> addCat(@RequestBody MatchStats stat) {
        System.out.println("AAAA");
        return rSocketRequester
                .route("addStat")
                .data(stat)
                .retrieveMono(MatchStats.class);
    }
}
