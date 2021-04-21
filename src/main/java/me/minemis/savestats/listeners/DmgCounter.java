package me.minemis.savestats.listeners;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.DataManager;
import me.minemis.savestats.system.PlayerCache;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.logging.Logger;

public class DmgCounter implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player){
            //If doesn't work try this
            //SaveStats saveStats = SaveStats.getInstance();
            //DataManager dataManager = saveStats.getDataManager();

            DataManager dataManager = SaveStats.getInstance().getDataManager();
            PlayerCache playerCache = dataManager.getPlayerCache(((Player) event.getDamager()).getPlayer().getName());
            playerCache.addTotalDamage(event.getDamage());
            Logger log = Bukkit.getLogger();
            log.info("Damage: " + event.getDamage());
            log.info("Total Damage: " + playerCache.getTotalDamage());
        }
    }
}
