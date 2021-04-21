package me.minemis.savestats.system;

public class ServerCache {
    public double largestDamage = 0;

    public void setLargestDamage(double largestDamage) {
        this.largestDamage = largestDamage;
    }

    public double getLargestDamage() {
        return largestDamage;
    }
}
