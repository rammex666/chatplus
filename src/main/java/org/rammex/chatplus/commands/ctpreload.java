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
        Player player = (Player) sender;

        this.plugin.reloadConfig();

        if(this.plugin.getConfig().getString("lang") == "en"){
            player.sendMessage(Objects.requireNonNull(hex(this.plugin.geten().getString("succes_message.reload"))));
        } else if (this.plugin.getConfig().getString("lang") == "fr") {
            player.sendMessage(Objects.requireNonNull(hex(this.plugin.getfr().getString("succes_message.reload"))));
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
