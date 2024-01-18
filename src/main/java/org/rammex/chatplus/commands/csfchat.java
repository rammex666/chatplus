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

public class csfchat implements CommandExecutor {

    Chatplus plugin;

    public csfchat(Chatplus plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String lang= this.plugin.getConfig().getString("lang");
        if (!(sender instanceof Player)) {
            if(lang.equals("en")){
                sender.sendMessage(hex(this.plugin.geten().getString("errormessage.notplayer")));
            }
            if(lang.equals("fr")){
                sender.sendMessage(hex(this.plugin.getfr().getString("errormessage.notplayer")));
            }
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("sf.see")) {
            if(lang.equals("en")){
                player.sendMessage(hex(this.plugin.geten().getString("errormessage.noperm")));
            }
            if(lang.equals("fr")){
                player.sendMessage(hex(this.plugin.getfr().getString("errormessage.noperm")));
            }
            return true;
        }
        if (args.length < 1) {
            if(lang.equals("en")){
                player.sendMessage(hex(this.plugin.geten().getString("commandsusage.sfchat")));
            }
            if(lang.equals("fr")){
                player.sendMessage(hex(this.plugin.getfr().getString("commandsusage.sfchat")));
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
