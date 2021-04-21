package me.minemis.savestats.commands;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.PlayerCache;
import me.minemis.savestats.system.TimeConverter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TotalTime implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        PlayerCache playerCache = SaveStats.getInstance().getDataManager().getPlayerCache(player.getName());

        player.sendMessage("Total time played: " +
                TimeConverter.millisToTime((playerCache.getTotalTime() + (System.currentTimeMillis() -
                        playerCache.getLastLogin())))
                    );

        return false;
    }
}
