package me.minemis.savestats.listeners;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.ServerCache;
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

            DataManager dataManager = SaveStats.getInstance().getDataManager();
            PlayerCache playerCache = dataManager.getPlayerCache(((Player) event.getDamager()).getPlayer().getName());
            playerCache.addTotalDamage(event.getDamage());
            Logger log = Bukkit.getLogger();

            ServerCache largestDamage =  SaveStats.getInstance().getLargestDamage();
            if (largestDamage.getLargestDamage() < playerCache.getTotalDamage() ){
                largestDamage.setLargestDamage(playerCache.getTotalDamage());
            }
            log.info("Damage: " + event.getDamage());
            log.info("Total Damage: " + playerCache.getTotalDamage());
            log.info("Largest Damage: " + SaveStats.getInstance().getLargestDamage().getLargestDamage());
        }
    }
}
