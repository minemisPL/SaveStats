package me.minemis.savestats.system;

public class PlayerCache {

    private final String name;

    private double totalDamage = 0;


    protected PlayerCache(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public double getTotalDamage() {
        return totalDamage;
    }

    public void addTotalDamage(double totalDamage) {
        this.totalDamage = this.totalDamage + totalDamage;
    }
}
