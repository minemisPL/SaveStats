package me.minemis.savestats.system;

import me.minemis.savestats.SaveStats;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {

    private final Map<String, PlayerCache> playerCacheMap = new HashMap<>();
    private final SaveStats saveStats;

    public DataManager(SaveStats saveStats){
        this.saveStats = saveStats;
        createIfNotExistFileJSON();
        new ReadFromFile(this, saveStats).readDataJSON();
    }

    public void createIfNotExistFileJSON() {
        File folder = new File(this.saveStats.getDataFolder().getPath());
        File file = new File(folder.getPath() + "/data.json");

        if (file.exists()){
            return;
        }

        try {
            folder.mkdir();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PlayerCache getPlayerCache(String playerName) {
        if (!playerCacheMap.containsKey(playerName)){
            PlayerCache playerCache = new PlayerCache(playerName);
            playerCacheMap.put(playerName, playerCache);
            return playerCache;
        }

        return playerCacheMap.get(playerName);
    }


    public List<PlayerCache> getPlayerList(){
       return new ArrayList<>(playerCacheMap.values());
    }

    public Map<String, PlayerCache> getPlayerCacheMap() {
        return playerCacheMap;
    }

    public void clearData() {
        for (PlayerCache playerCache : playerCacheMap.values()) {
            playerCache.clearData();
        }
    }
}
