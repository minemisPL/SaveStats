package me.minemis.savestats.system;

import me.minemis.savestats.SaveStats;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    private final DataManager dataManager;

    public ReadFromFile(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void readDataJSON(){
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader(SaveStats.getInstance().getDataFolder().getPath() + "/data.json");

            Object obj = jsonParser.parse(reader);

            JSONObject playersList = (JSONObject) obj;

//            if (obj.toString().equals("")){
//                return;
//            }

            for (Object key : playersList.keySet()) {

                JSONObject valuesPlayer = (JSONObject) playersList.get(key);
                String name = (String) valuesPlayer.get("name");
                if (!(valuesPlayer.get("TotalDamage") == null)){
                    double totalDamage = (double) valuesPlayer.get("TotalDamage");
                    dataManager.getPlayerCache(name).addTotalDamage(totalDamage);

                    ServerCache largestDamage =  SaveStats.getInstance().getLargestDamage();
                    if (largestDamage.getLargestDamage() < totalDamage ){
                        largestDamage.setLargestDamage(totalDamage);
                    }
                }
                else {
                    dataManager.getPlayerCache(name).addTotalDamage(0);
                }


                if (!(valuesPlayer.get("Total time played") == null)){
                    long totalTime = (long) valuesPlayer.get("Total time played");
                    dataManager.getPlayerCache(name).setTotalTime(totalTime);
                }
                else {
                    dataManager.getPlayerCache(name).setTotalTime(0);
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
