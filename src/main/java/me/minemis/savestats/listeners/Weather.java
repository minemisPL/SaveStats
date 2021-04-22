package me.minemis.savestats.listeners;

import me.minemis.savestats.SaveStats;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Weather implements Listener {

    @EventHandler
    public void keepWeatherClear(WeatherChangeEvent e){

        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                if (e.getWorld().hasStorm()){
                    e.getWorld().setStorm(false);
                }
            }
        };
        task.runTaskLater(SaveStats.getInstance(), 10);
    }
}
