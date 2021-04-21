package me.minemis.savestats.system;

import com.sk89q.worldedit.EditSessionFactory;
import com.sk89q.worldedit.WorldEdit;
import me.minemis.savestats.SaveStats;
import org.bukkit.Bukkit;
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

            for (Object key : playersList.keySet()) {

                JSONObject valuesPlayer = (JSONObject) playersList.get(key);
                String name = (String) valuesPlayer.get("name");
                double totalDamage = (double) valuesPlayer.get("TotalDamage");

                dataManager.getPlayerCache(name).addTotalDamage(totalDamage);

                //SaveStats saveStats = (SaveStats) Bukkit.getServer().getPluginManager().getPlugin("SaveStats");
                //WorldEdit worldEdit = (WorldEdit) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

                //Instancja worldedita
                //WorldEdit.getInstance();//i tak mają getInstance xD ale ciii
                //jeśli jakieś API pluginu nie ma getInstance() możesz w ten sposób pobrać ją
                //Po co ją pobierać? Co można z nią zrobić?
                //Możesz wykorzystać wszystkie metody z tej instancji
                //EditSessionFactory editSessionFactory = worldEdit.getEditSessionFactory();
                //editSessionFactory.getEditSession(worldEdit.get), 100);
                //???!?!?!??
                // tak można pobrać główną instację każdego pluginu
                //Po co mi ona tutaj?nwxD

                //Wszystko w pętli podczas wczytywnia pliku XDD

                //Dobra dobra cwaniaczku chcę teraz spróbować zrobić nową porządkną fukncje!!!!
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();//ej jest jakieś zadanie?
             //Sam nie wiem, ale raczej nie :P
            //ona coś mówiła?
            //Zapytam Oskara Oskar mówi, że nic nie było;
        }

    }
    //Puki to działa daj mi się pobawić, ok? Zrobię swoje dodatkowe funkcje! I powiem Ci jak mi wyjebie tona błędów :3

}
//???