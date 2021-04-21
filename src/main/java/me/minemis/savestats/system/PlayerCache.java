package me.minemis.savestats.system;

public class PlayerCache {

    private final String name;

    protected PlayerCache(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
