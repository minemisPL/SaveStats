package me.minemis.savestats.system;

import me.minemis.savestats.SaveStats;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    private final DataManager dataManager;
    private final SaveStats saveStats;

    public ReadFromFile(DataManager dataManager, SaveStats saveStats) {
        this.dataManager = dataManager;
        this.saveStats = saveStats;
    }

    public void readDataJSON(){
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(saveStats.getDataFolder().getPath() + "/data.json");
            ServerCache serverCache =  saveStats.getServerCache();
            Object obj = jsonParser.parse(reader);
            JSONObject playersList = (JSONObject) obj;

            for (Object key : playersList.keySet()) {
                JSONObject valuesPlayer = (JSONObject) playersList.get(key);
                String name = (String) valuesPlayer.get("name");
                PlayerCache playerCache = dataManager.getPlayerCache(name);

                Object objectTotalDamage = valuesPlayer.get("TotalDamage");

                if (objectTotalDamage == null) {
                    objectTotalDamage = 0.0D;
                }

                double totalDamage = (double) objectTotalDamage;

                if (serverCache.getLargestDamage() < totalDamage) {
                    serverCache.setLargestDamage(totalDamage);
                }

                playerCache.addTotalDamage(totalDamage);

                Object objectTotalTimePlayed = valuesPlayer.get("Total time played");

                if (objectTotalTimePlayed == null){
                    objectTotalTimePlayed = 0L;
                }

                long totalTime = (long) objectTotalTimePlayed;
                playerCache.setTotalTime(totalTime);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
