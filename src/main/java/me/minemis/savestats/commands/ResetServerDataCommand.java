package me.minemis.savestats.commands;

import me.minemis.savestats.SaveStats;
import me.minemis.savestats.system.ResetData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetServerDataCommand implements CommandExecutor {

    private final SaveStats saveStats;

    public ResetServerDataCommand(SaveStats saveStats) {
        this.saveStats = saveStats;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player) || !sender.isOp()) return false;

        new ResetData(saveStats).resetDataFile();

        return false;
    }

}
