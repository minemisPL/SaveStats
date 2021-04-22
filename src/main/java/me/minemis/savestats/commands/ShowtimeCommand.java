package me.minemis.savestats.commands;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.DataManager;
import me.minemis.savestats.system.PlayerCache;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class ShowtimeCommand implements CommandExecutor {

    private final SaveStats saveStats;

    public ShowtimeCommand(SaveStats saveStats) {
        this.saveStats = saveStats;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        try {
            player.sendMessage("Time played: " + getTime(player));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }
    public String getTime(Player player) throws FileNotFoundException {

        DataManager dataManager = saveStats.getDataManager();
        PlayerCache playerCache = dataManager.getPlayerCache(player.getName());

        long currentTime = System.currentTimeMillis() - playerCache.getLastLogin();
        long sek = TimeUnit.MILLISECONDS.toSeconds(currentTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentTime));

        return String.format("%02d min, %02d sec", TimeUnit.MILLISECONDS.toMinutes(currentTime), sek);
    }
}
