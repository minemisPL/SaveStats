package me.minemis.savestats.system;

import me.minemis.savestats.SaveStats;

public class ServerCache {

    private final SaveStats saveStats;
    private double largestDamage = 0;

    public ServerCache(SaveStats saveStats) {
        this.saveStats = saveStats;
    }

    public void setLargestDamage(double largestDamage) {
        this.largestDamage = largestDamage;
    }

    public double getLargestDamage() {
        return largestDamage;
    }
}
