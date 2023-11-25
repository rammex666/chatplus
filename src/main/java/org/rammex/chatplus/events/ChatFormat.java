package org.rammex.chatplus.events;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.rammex.chatplus.Chatplus;

import java.util.List;

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
                // Le message contient un mot banni, annulez l'événement et informez le joueur
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "Votre message contient un mot banni.");
                return;
            }
        }

        String playerName = event.getPlayer().getDisplayName();
        String world = event.getPlayer().getWorld().getName();

        message = message.replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString());

        message = PlaceholderAPI.setPlaceholders(event.getPlayer(), message).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString());

        String formattedMessage = this.plugin.getConfig().getString("chatformat.format").replace("{player}", playerName).replace("{message}", message).replace("{world}", world).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString());


        formattedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString());;

        getServer().broadcastMessage(formattedMessage);




    }


}
