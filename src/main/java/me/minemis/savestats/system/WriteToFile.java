package me.minemis.savestats.system;

import me.minemis.savestats.SaveStats;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteToFile {

    private FileWriter file;

    public void writeToDataJSON(DataManager dataManager) {

        Map<String,PlayerCache> map = dataManager.getPlayerCacheMap();

        //JSONArray playerJSONArray = new JSONArray();
        JSONObject playerStats = new JSONObject();

        for (Map.Entry<String, PlayerCache> cacheMap : map.entrySet()){
            JSONObject playerJSONObject = new JSONObject();

            playerJSONObject.put("name", cacheMap.getValue().getName());
            playerJSONObject.put("TotalDamage", cacheMap.getValue().getTotalDamage());
            playerJSONObject.put("Total time played", cacheMap.getValue().getTotalTime());

            playerStats.put(cacheMap.getKey(),playerJSONObject);
            //playerJSONArray.add(playerJSONObject);
        }


        try {

            file = new FileWriter(SaveStats.getInstance().getDataFolder().getPath() + "/data.json");
            file.write(playerStats.toJSONString());

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                file.flush();
                file.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }
