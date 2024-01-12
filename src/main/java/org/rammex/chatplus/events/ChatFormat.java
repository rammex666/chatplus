package org.rammex.chatplus.events;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.rammex.chatplus.Chatplus;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.bukkit.Bukkit.getServer;

public class ChatFormat implements Listener {

    Chatplus plugin;

    public ChatFormat(Chatplus plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);
        List<String> bannedWords = plugin.getConfig().getStringList("banned-words");
        String message = event.getMessage();
        for (String bannedWord : bannedWords) {
            if (message.toLowerCase().contains(bannedWord.toLowerCase())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "Your Message Contains A Ban Word");
                return;
            }
        }

        String playerName = event.getPlayer().getDisplayName();
        String world = event.getPlayer().getWorld().getName();
        if(event.getPlayer().hasPermission("ctp.color")){
            message = hex(message);

            message = PlaceholderAPI.setPlaceholders(event.getPlayer(), hex(message));
            String formattedMessage = hex(this.plugin.getConfig().getString("chatformat.format").replace("\\","").replace("{player}", playerName).replace("{message}", message).replace("{world}", world));

            formattedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage);
            getServer().broadcastMessage(formattedMessage);
        } else{
            String chatFormat = this.plugin.getConfig().getString("chatformat.format");

            String[] formatParts = chatFormat.split("\\{message\\}", 2);

            if (formatParts.length == 2) {
                String messagePart = formatParts[0];
                String restPart = formatParts[1];

                String formattedMessage = hex(messagePart) + message + hex(restPart);
                formattedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage.replace("\\","").replace("{player}", playerName).replace("{world}", world));
                getServer().broadcastMessage(formattedMessage);
            } else {
                event.getPlayer().sendMessage("Erreur de format du chat. Veuillez contacter l'administrateur du serveur.");
            }
        }








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
