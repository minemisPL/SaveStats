package me.minemis.savestats.commands;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.PlayerCache;
import me.minemis.savestats.utils.TimeConvertUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TotalTimeCommand implements CommandExecutor {

    private final SaveStats saveStats;

    public TotalTimeCommand(SaveStats saveStats) {
        this.saveStats = saveStats;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        PlayerCache playerCache = saveStats.getDataManager().getPlayerCache(player.getName());

        player.sendMessage("Total time played: " +
                TimeConvertUtils.millisToTime((playerCache.getTotalTime() + (System.currentTimeMillis() -
                        playerCache.getLastLogin())))
                    );

        return false;
    }
}
