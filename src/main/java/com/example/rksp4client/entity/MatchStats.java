package com.example.rksp4client.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class MatchStats {
    @JsonProperty
    private Long id;

    @JsonProperty
    private Integer countTeam1;

    @JsonProperty
    private Integer countTeam2;

    @JsonProperty
    private Integer bestADR;

    @JsonProperty
    private Integer bestKD;

    // Публичный конструктор по умолчанию
    public MatchStats() {}
}
