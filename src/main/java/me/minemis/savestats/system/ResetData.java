package me.minemis.savestats.system;

import me.minemis.savestats.SaveStats;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class ResetData {

    private File original;

    public void resetDataFile() throws IOException {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date(System.currentTimeMillis());

        original = new File(SaveStats.getInstance().getDataFolder().getPath() + "/data.json");

        File file = new File(SaveStats.getInstance().getDataFolder().getPath() + "/dataBackup" + formatter.format(date) + ".json");
        file.createNewFile();

        Path copied = Paths.get(file.getPath());
        Path originalPath = Paths.get(original.getPath());
        Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);

        if (original.delete()){
            Logger log = Bukkit.getLogger();
            log.info("Data file has been reset");

            new WriteToFile().writeToDataJSON(new DataManager());
        }
    }
}
