package org.rammex.chatplus.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.rammex.chatplus.Chatplus;

import java.util.Collections;
import java.util.List;

public class TemplatesChatFormat {

    static Chatplus plugin;

    public static void tmpltctft(Player player){
        Inventory inv = Bukkit.createInventory(null, 54, "Chat Format");

        //templates







        // top
        inv.setItem(0, getItem(Material.BARRIER, ChatColor.RED+"Back", null));
        inv.setItem(1, getItem(Material.GRAY_STAINED_GLASS_PANE, null,null));
        inv.setItem(2, getItem(Material.GRAY_STAINED_GLASS_PANE, null,null));
        inv.setItem(3, getItem(Material.PAPER, "Actual", Collections.singletonList(plugin.getConfig().getString("chatformat.format"))));
        inv.setItem(4, getItem(Material.GRAY_STAINED_GLASS_PANE, null,null));
        inv.setItem(5, getItem(Material.GRAY_STAINED_GLASS_PANE, null,null));
        inv.setItem(6, getItem(Material.GRAY_STAINED_GLASS_PANE, null,null));
        inv.setItem(7, getItem(Material.GRAY_STAINED_GLASS_PANE, null,null));
        inv.setItem(8, getItem(Material.GRAY_STAINED_GLASS_PANE, null,null));




        player.openInventory(inv);
    }


    public static ItemStack getItem(Material material, String customName, List<String> lore) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        if (lore != null) customM.setLore(lore);
        it.setItemMeta(customM);
        return it;
    }
}
