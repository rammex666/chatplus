package org.rammex.chatplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;

import static org.rammex.chatplus.utils.ColorUtil.hex;

public class CsfChat implements CommandExecutor {
    private final Chatplus plugin;

    public CsfChat(Chatplus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String language = this.plugin.getConfig().getString("lang");
        if (!(sender instanceof Player)) {
            switch (language) {
                case "en" -> sender.sendMessage(hex(this.plugin.getEnConf().getString("errormessage.notplayer")));
                case "fr" -> sender.sendMessage(hex(this.plugin.getFrConf().getString("errormessage.notplayer")));
                case "de" -> sender.sendMessage(hex(this.plugin.getDeConf().getString("errormessage.notplayer")));
            }
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("sf.see")) {
            switch (language) {
                case "en" -> player.sendMessage(hex(this.plugin.getEnConf().getString("errormessage.noperm")));
                case "fr" -> player.sendMessage(hex(this.plugin.getFrConf().getString("errormessage.noperm")));
                case "de" -> player.sendMessage(hex(this.plugin.getDeConf().getString("errormessage.noperm")));
            }
            return true;
        }

        if (args.length < 1) {
            switch (language) {
                case "en" -> player.sendMessage(hex(this.plugin.getEnConf().getString("commandsusage.sfchat")));
                case "fr" -> player.sendMessage(hex(this.plugin.getFrConf().getString("commandsusage.sfchat")));
                case "de" -> player.sendMessage(hex(this.plugin.getDeConf().getString("commandsusage.sfchat")));
            }
            return true;
        }

        StringBuilder messageBuilder = new StringBuilder();
        for (String arg : args) {
            messageBuilder.append(arg).append(" ");
        }
        String message = messageBuilder.toString().trim();
        for (Player onlinePlayer : this.plugin.getServer().getOnlinePlayers()) {
            if (onlinePlayer.hasPermission("sf.see")) {
                onlinePlayer.sendMessage("§5§l[StaffChat]§r§c "+player.getName()+" >> §r"+ hex(message));
            }
        }

        return true;
    }
}