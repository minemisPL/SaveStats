package me.minemis.savestats;

import me.minemis.savestats.commands.ResetServerDataCommand;
import me.minemis.savestats.commands.ShowtimeCommand;
import me.minemis.savestats.commands.TotalTimeCommand;
import me.minemis.savestats.listeners.PlayerQuit;
import me.minemis.savestats.listeners.WeatherChange;
import me.minemis.savestats.system.ServerCache;
import me.minemis.savestats.listeners.DmgCounter;
import me.minemis.savestats.listeners.PlayerJoin;
import me.minemis.savestats.system.DataManager;
import me.minemis.savestats.system.WriteToFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SaveStats extends JavaPlugin {

    private DataManager dataManager;
    private ServerCache serverCache;

    @Override
    public void onEnable() {
        serverCache = new ServerCache(this);
        dataManager = new DataManager(this);

        PluginManager pm = this.getServer().getPluginManager();

        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this), this);
        pm.registerEvents(new DmgCounter(this), this);
        pm.registerEvents(new WeatherChange(this), this);

        this.getCommand("showtime").setExecutor(new ShowtimeCommand(this));
        this.getCommand("totaltime").setExecutor(new TotalTimeCommand(this));
        this.getCommand("resetServerData").setExecutor(new ResetServerDataCommand(this));
    }

    @Override
    public void onDisable() {
        try {
            new WriteToFile(this).writeToDataJSON(getDataManager());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public ServerCache getServerCache() {
        return serverCache;
    }
}
