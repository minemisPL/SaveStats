package me.minemis.savestats.listeners;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.DataManager;
import me.minemis.savestats.system.PlayerCache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private final SaveStats saveStats;

    public PlayerJoin(SaveStats saveStats) {
        this.saveStats = saveStats;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        DataManager dataManager = saveStats.getDataManager();
        PlayerCache playerCache = dataManager.getPlayerCache(event.getPlayer().getName());

        dataManager.getPlayerCache(event.getPlayer().getName());
        playerCache.setLastLogin(System.currentTimeMillis());
    }

}
