package com.example.rksp4client.controllers;

import com.example.rksp4client.StatsListWrapper;
import com.example.rksp4client.entity.MatchStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/stats")

public class ChannelController {
    private final RSocketRequester rSocketRequester;
    @Autowired
    public ChannelController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }
    @PostMapping("/exp")
    public Flux<MatchStats> addCatsMultiple(@RequestBody StatsListWrapper
                                             statsListWrapper){
        List<MatchStats> catList = statsListWrapper.getStats();
        Flux<MatchStats> cats = Flux.fromIterable(catList);
        return rSocketRequester
                .route("statsChannel")
                .data(cats)
                .retrieveFlux(MatchStats.class);
    }

}
