package me.minemis.savestats;

import me.minemis.savestats.system.ServerCache;
import me.minemis.savestats.listeners.DmgCounter;
import me.minemis.savestats.listeners.PlayerJoin;
import me.minemis.savestats.system.DataManager;
import me.minemis.savestats.system.WriteToFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SaveStats extends JavaPlugin {

    private DataManager dataManager;
    private static SaveStats instance;
    PluginManager pm;
    private ServerCache serverCache;

    @Override
    public void onEnable() {
        instance = this;

        serverCache = new ServerCache();
        dataManager = new DataManager();
        pm = this.getServer().getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new DmgCounter(), this);

    }

    @Override
    public void onDisable() {
        try {
            new WriteToFile().writeToDataJSON(getDataManager());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static SaveStats getInstance() {
        return instance;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public ServerCache getLargestDamage(){
        return serverCache;
    }
}
