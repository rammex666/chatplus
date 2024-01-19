package org.rammex.chatplus.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ctpreload implements CommandExecutor {
    Chatplus plugin;
    public ctpreload(Chatplus plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        String lang= this.plugin.getConfig().getString("lang");
        Player player = (Player) sender;

        this.plugin.reloadConfig();

        if(lang.equals("en")){
            player.sendMessage(hex(this.plugin.geten().getString("succesmessage.reload")));
        }
        if(lang.equals("fr")){
            player.sendMessage(hex(this.plugin.getfr().getString("succesmessage.reload")));
        }
        if(lang.equals("de")){
            player.sendMessage(hex(this.plugin.getde().getString("succesmessage.reload")));
        }
        return false;
    }

    public static String hex(String message) {
        Pattern pattern = Pattern.compile("(#[a-fA-F0-9]{6})");
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            String hexCode = message.substring(matcher.start(), matcher.end());
            String replaceSharp = hexCode.replace('#', 'x');

            char[] ch = replaceSharp.toCharArray();
            StringBuilder builder = new StringBuilder("");
            for (char c : ch) {
                builder.append("&" + c);
            }

            message = message.replace(hexCode, builder.toString());
            matcher = pattern.matcher(message);
        }
        return ChatColor.translateAlternateColorCodes('&', message).replace('&', '§');
    }
}
