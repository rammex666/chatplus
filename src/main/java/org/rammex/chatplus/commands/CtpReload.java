package org.rammex.chatplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;

import static org.rammex.chatplus.utils.ColorUtil.hex;

public class CtpReload implements CommandExecutor {
    private final Chatplus plugin;

    public CtpReload(Chatplus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        String language = this.plugin.getConfig().getString("lang");
        Player player = (Player) sender;
        this.plugin.reloadConfig();
        switch (language) {
            case "en" -> player.sendMessage(hex(this.plugin.getEnConf().getString("succesmessage.reload")));
            case "fr" -> player.sendMessage(hex(this.plugin.getFrConf().getString("succesmessage.reload")));
            case "de" -> player.sendMessage(hex(this.plugin.getDeConf().getString("succesmessage.reload")));
        }
        return false;
    }
}