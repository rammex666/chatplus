package org.rammex.chatplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.ui.adminpanel;

public class ctpadmin implements CommandExecutor {
    Chatplus plugin;

    public ctpadmin(Chatplus plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        adminpanel.getadminpanel(player);
        return false;
    }
}
