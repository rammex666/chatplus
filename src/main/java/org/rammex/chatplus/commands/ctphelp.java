package org.rammex.chatplus.commands;

import net.kyori.adventure.platform.facet.Facet;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;

public class ctphelp implements CommandExecutor {
    Chatplus plugin;
    public ctphelp(Chatplus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        Player player = (Player) sender;
        String lang= this.plugin.getConfig().getString("lang");
        switch (lang) {
            case "fr" -> {
                fr(player);
            }
            case "en" -> {
                en(player);
            }
            case "de" -> {
                de(player);
            }
        }

        return false;
    }



    void fr(Player player){
        player.sendMessage(ChatColor.BLUE+"--------------------");
        player.sendMessage(ChatColor.AQUA+"ChatPlus | Version 1.3");
        player.sendMessage("");
        player.sendMessage(ChatColor.AQUA+"/ctphelp | Liste des commandes");
        player.sendMessage(ChatColor.AQUA+"/ctpadmin | Config de CTP");
        player.sendMessage(ChatColor.AQUA+"/ctpgp | Parler dans un chat de groupe");
        player.sendMessage(ChatColor.AQUA+"/sfchat | Parler dans le chat du personnel");
        player.sendMessage(ChatColor.AQUA+"/ctpreload | Recharger la configuration");
        player.sendMessage(ChatColor.BLUE+"--------------------");
    }
    void de(Player player){
        player.sendMessage(ChatColor.BLUE+"--------------------");
        player.sendMessage(ChatColor.AQUA+"ChatPlus | Version 1.3");
        player.sendMessage("");
        player.sendMessage(ChatColor.AQUA+"/ctphelp | Liste der Befehle");
        player.sendMessage(ChatColor.AQUA+"/ctpadmin | Konfig von CTP");
        player.sendMessage(ChatColor.AQUA+"/ctpgp | In einem Gruppenchat sprechen");
        player.sendMessage(ChatColor.AQUA+"/sfchat | Im Mitarbeiter-Chat sprechen");
        player.sendMessage(ChatColor.AQUA+"/ctpreload | Die Konfiguration neu laden");
        player.sendMessage(ChatColor.BLUE+"--------------------");
    }
    void en(Player player){
        player.sendMessage(ChatColor.BLUE+"--------------------");
        player.sendMessage(ChatColor.AQUA+"ChatPlus | Version 1.3");
        player.sendMessage("");
        player.sendMessage(ChatColor.AQUA+"/ctphelp | List of Commands");
        player.sendMessage(ChatColor.AQUA+"/ctpadmin | Config of CTP");
        player.sendMessage(ChatColor.AQUA+"/ctpgp | Talk in a group chat");
        player.sendMessage(ChatColor.AQUA+"/sfchat | Talk in the staff chat");
        player.sendMessage(ChatColor.AQUA+"/ctpreload | Reload The config");
        player.sendMessage(ChatColor.BLUE+"--------------------");
    }



}
