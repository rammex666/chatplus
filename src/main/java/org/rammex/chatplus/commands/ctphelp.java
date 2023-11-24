package org.rammex.chatplus.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ctphelp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        Player player = (Player) sender;

        player.sendMessage(ChatColor.BLUE+"--------------------");
        player.sendMessage(ChatColor.AQUA+"ChatPlus | Version 1.0");
        player.sendMessage("");
        player.sendMessage(ChatColor.AQUA+"/ctphelp | List of Commands");
        player.sendMessage(ChatColor.AQUA+"/ctpadmin | Config of CTP");
        player.sendMessage(ChatColor.BLUE+"--------------------");

        return false;
    }
}
