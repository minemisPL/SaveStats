package me.minemis.savestats.listeners;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.ServerCache;
import me.minemis.savestats.system.DataManager;
import me.minemis.savestats.system.PlayerCache;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DmgCounter implements Listener {

    private final SaveStats saveStats;

    public DmgCounter(SaveStats saveStats) {
        this.saveStats = saveStats;
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        Player player = (Player) event.getDamager();
        DataManager dataManager = saveStats.getDataManager();
        PlayerCache playerCache = dataManager.getPlayerCache(player.getName());
        ServerCache largestDamage =  saveStats.getServerCache();

        playerCache.addTotalDamage(event.getDamage());

        if (largestDamage.getLargestDamage() < playerCache.getTotalDamage() ){
            largestDamage.setLargestDamage(playerCache.getTotalDamage());
        }
    }
}
