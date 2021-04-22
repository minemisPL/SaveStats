package me.minemis.savestats.listeners;

import me.minemis.savestats.SaveStats;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChange implements Listener {

    private final SaveStats saveStats;

    public WeatherChange(SaveStats saveStats) {
        this.saveStats = saveStats;
    }

    @EventHandler
    public void keepWeatherClear(WeatherChangeEvent e) {
        World world = e.getWorld();

        Bukkit.getScheduler().runTaskLater(saveStats, () -> {
            if (!world.hasStorm()) {
                return;
            }

            world.setStorm(false);
        }, 10L);
        //programowanie funkcyjne? :blush:
    }
}
