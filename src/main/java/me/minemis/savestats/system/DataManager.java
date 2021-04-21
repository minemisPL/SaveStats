package me.minemis.savestats.system;

import me.minemis.savestats.SaveStats;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {

    private final Map<String, PlayerCache> playerCacheMap = new HashMap<>();

    public DataManager(){
        File file = new File(SaveStats.getInstance().getDataFolder().getPath() + "/data.json");
        if (!file.exists()){
            try {
                file.mkdir();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        new ReadFromFile(this).readDataJSON();
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
}
