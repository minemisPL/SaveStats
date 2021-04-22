package me.minemis.savestats.system;

public class PlayerCache {

    private final String name;

    private double totalDamage = 0.0D;

    private long sessionTime = 0L;
    private long lastLogin = 0L;
    private long totalTime = 0L;

    protected PlayerCache(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getTotalDamage() {
        return totalDamage;
    }

    public long getLastLogin() {
        return lastLogin;
    }

    public long getSessionTime() {
        return sessionTime;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setLastLogin(long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setSessionTime(long sessionTime) {
        this.sessionTime = sessionTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public void addTotalDamage(double totalDamage) {
        this.totalDamage = this.totalDamage + totalDamage;
    }

    public void addTotalTime(long totaltime){
        this.totalTime = (this.totalTime + totaltime);
    }

    public void clearData() {
        totalDamage = 0.0D; // <- Hey programmer! This value is double. Please don't forget!
        sessionTime = 0L;
        lastLogin = 0L;
        totalTime = 0L;
    }
}

