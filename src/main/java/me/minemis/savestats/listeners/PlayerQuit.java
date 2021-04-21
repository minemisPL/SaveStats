package me.minemis.savestats.listeners;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.PlayerCache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        PlayerCache playerCache = SaveStats.getInstance().getDataManager().getPlayerCache(e.getPlayer().getName());
        playerCache.setSessionTime(System.currentTimeMillis() - playerCache.getLastLogin());

        playerCache.addTotalTime(playerCache.getSessionTime());
    }
}
