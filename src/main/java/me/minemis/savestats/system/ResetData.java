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

    private final SaveStats saveStats;

    public ResetData(SaveStats saveStats) {
        this.saveStats = saveStats;
    }

    public void resetDataFile() {
        try {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            Date date = new Date(System.currentTimeMillis());

            original = new File(saveStats.getDataFolder().getPath() + "/data.json");

            File file = new File(saveStats.getDataFolder().getPath() + "/dataBackup" + formatter.format(date) + ".json");

            file.createNewFile();

            Path copied = Paths.get(file.getPath());
            Path originalPath = Paths.get(original.getPath());
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
            Logger log = Bukkit.getLogger();

            if (!original.delete()) {
                log.warning("Idk what happened Bro");
            }

            log.info("Data file has been reset");
            saveStats.getDataManager().clearData();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
