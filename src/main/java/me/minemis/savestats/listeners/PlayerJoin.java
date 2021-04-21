package me.minemis.savestats.listeners;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.DataManager;
import me.minemis.savestats.system.PlayerCache;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        SaveStats saveStats = SaveStats.getInstance();
        DataManager dataManager = saveStats.getDataManager();
        PlayerCache playerCache = dataManager.getPlayerCache(event.getPlayer().getName());

        dataManager.getPlayerCache(event.getPlayer().getName());
        playerCache.setLastLogin(System.currentTimeMillis());
    }

}
