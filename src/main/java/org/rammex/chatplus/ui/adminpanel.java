package org.rammex.chatplus.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.events.ChatFormat;

public class adminpanel {

    static Chatplus plugin;


    public static void getadminpanel(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "Admin Panel");

        inv.setItem(11, getItem(Material.PAPER, ChatColor.RED+"Chat Format"));
        inv.setItem(13, getItem(Material.BOOK, ChatColor.RED+"ScoreBoard"));
        inv.setItem(15, getItem(Material.REDSTONE, ChatColor.RED+"OverAll"));

        player.openInventory(inv);
    }

    public static void chatformatpanel(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "Chat Format");

        inv.setItem(11, getItem(Material.ANVIL, ChatColor.AQUA+"Templates"));
        inv.setItem(13, getItem(Material.PAPER, ChatColor.RED+"SOON"));
        inv.setItem(15, getItem(Material.CRAFTING_TABLE, ChatColor.AQUA+"Change"));

        inv.setItem(18, getItem(Material.BARRIER, ChatColor.RED+"Back"));


        player.openInventory(inv);
    }

    public static void scoreboardpanel(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "ScoreBoard");

        inv.setItem(11, getItem(Material.ANVIL, ChatColor.AQUA+"Templates"));
        inv.setItem(13, getItem(Material.PAPER, ChatColor.RED+"SOON"));
        inv.setItem(15, getItem(Material.CRAFTING_TABLE, ChatColor.AQUA+"Change"));

        inv.setItem(18, getItem(Material.BARRIER, ChatColor.RED+"Back"));


        player.openInventory(inv);
    }

    public static ItemStack getItem(Material material, String customName) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        it.setItemMeta(customM);
        return it;
    }
}
