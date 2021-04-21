package me.minemis.savestats.commands;

import me.minemis.savestats.system.ResetData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ResetServerData implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player) || !sender.isOp()) return false;

        try {
            new ResetData().resetDataFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
