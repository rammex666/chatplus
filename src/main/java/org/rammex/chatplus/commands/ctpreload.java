package org.rammex.chatplus.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;

public class ctpreload implements CommandExecutor {
    Chatplus plugin;
    public ctpreload(Chatplus plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;

        this.plugin.reloadConfig();

        player.sendMessage(ChatColor.GREEN+"[ChatPlus] Config Has Been Reload");
        return false;
    }
}
