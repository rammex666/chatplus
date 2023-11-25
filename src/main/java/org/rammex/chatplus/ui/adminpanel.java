package org.rammex.chatplus.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class adminpanel {


    public static void getadminpanel(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "Admin Panel");

        inv.setItem(11, getItem(Material.PAPER, ChatColor.RED+"Chat Format"));
        inv.setItem(13, getItem(Material.BEDROCK, ChatColor.RED+"SOON"));
        inv.setItem(15, getItem(Material.BEDROCK, ChatColor.RED+"SOON"));

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
