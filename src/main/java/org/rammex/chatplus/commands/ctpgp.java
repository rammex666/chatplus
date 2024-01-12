package org.rammex.chatplus.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ctpgp implements CommandExecutor {
    Chatplus plugin;
    public ctpgp(Chatplus plugin) {
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Cette commande ne peut être exécutée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage("Utilisation : /ctpgp <group>");
            return true;
        }

        String group = args[0].toLowerCase();

        if (!this.plugin.getConfig().contains("groupschat." + group)) {
            player.sendMessage("This group doesn't exist.");
            return true;
        }

        String permission = this.plugin.getConfig().getString("groupschat." + group + ".permission");

        if (!player.hasPermission(permission)) {
            player.sendMessage("You don't have permission to talk in this groupchat");
            return true;
        }
        String playerName = player.getName();
        String groupMessage = String.join(" ", args).substring(args[0].length());

        String title = hex(this.plugin.getConfig().getString("groupschat." + group + ".title"));
        if (title == null) {
            title = hex("#98FFF1[GROUPCHAT]"); // Remplacez par une valeur par défaut ou ajustez selon votre logique
        }

        String formattedMessage = hex(this.plugin.getConfig().getString("chatformat.format")
                .replace("\\", "")
                .replace("{player}", playerName)
                .replace("{message}", groupMessage)
                .replace("{world}", player.getWorld().getName()));

        formattedMessage = PlaceholderAPI.setPlaceholders(player, formattedMessage);

        String message = String.format("%s %s", title, formattedMessage);
        for (Player onlinePlayer : this.plugin.getServer().getOnlinePlayers()) {
            if (onlinePlayer.hasPermission(permission)) {
                onlinePlayer.sendMessage(hex(message));
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
