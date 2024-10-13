package com.example.rksp4client;

import com.example.rksp4client.entity.MatchStats;

import java.util.List;

public class StatsListWrapper {
    private List<MatchStats> stats;
    public List<MatchStats> getStats() {
        return stats;
    }
    public void setStats(List<MatchStats> stats) {
        this.stats = stats;
    }

}
