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
        Inventory inv = Bukkit.createInventory(null, 54, "Chat Format Templates");

        // Templates line 1
        inv.setItem(9, getItem(Material.BOOK, "{player} = {message}",null));
        inv.setItem(10, getItem(Material.BOOK, "&7[{world}&7] &e{player}&7: &f{message}".replace("&e", ChatColor.YELLOW.toString()).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString()),null));
        inv.setItem(11, getItem(Material.BOOK, "&c[{world}&c] &a{player}&7: &e{message}".replace("&e", ChatColor.YELLOW.toString()).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString()),null));
        inv.setItem(12, getItem(Material.BOOK, "&c[&4{world}&c] &6{player}&e: &a{message}".replace("&e", ChatColor.YELLOW.toString()).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString()),null));
        inv.setItem(13, getItem(Material.BOOK, "&l[{world}] &l{player}&7: &l{message}".replace("&e", ChatColor.YELLOW.toString()).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString()),null));
        inv.setItem(14, getItem(Material.BOOK, "&o&n[{world}] &o&n{player}&7: &o&n{message}".replace("&e", ChatColor.YELLOW.toString()).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString()),null));
        inv.setItem(15, getItem(Material.BOOK, "&e{player} &7>> {message}".replace("&e", ChatColor.YELLOW.toString()).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString()),null));
        inv.setItem(16, getItem(Material.BOOK, "&e{player} &7=> {message}".replace("&e", ChatColor.YELLOW.toString()).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString()),null));
        inv.setItem(17, getItem(Material.BOOK, "&e{player} &7--> {message}".replace("&e", ChatColor.YELLOW.toString()).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString()),null));

        // Templates line 2
        inv.setItem(18, getItem(Material.BOOK, null,null));
        inv.setItem(19, getItem(Material.BOOK, null,null));
        inv.setItem(20, getItem(Material.BOOK, null,null));
        inv.setItem(21, getItem(Material.BOOK, null,null));
        inv.setItem(22, getItem(Material.BOOK, null,null));
        inv.setItem(23, getItem(Material.BOOK, null,null));
        inv.setItem(24, getItem(Material.BOOK, null,null));
        inv.setItem(25, getItem(Material.BOOK, null,null));
        inv.setItem(26, getItem(Material.BOOK, null,null));

        // Templates line 3
        inv.setItem(27, getItem(Material.BOOK, null,null));
        inv.setItem(28, getItem(Material.BOOK, null,null));
        inv.setItem(29, getItem(Material.BOOK, null,null));
        inv.setItem(30, getItem(Material.BOOK, null,null));
        inv.setItem(31, getItem(Material.BOOK, null,null));
        inv.setItem(32, getItem(Material.BOOK, null,null));
        inv.setItem(33, getItem(Material.BOOK, null,null));
        inv.setItem(34, getItem(Material.BOOK, null,null));
        inv.setItem(35, getItem(Material.BOOK, null,null));

        // Templates line 4
        inv.setItem(36, getItem(Material.BOOK, null,null));
        inv.setItem(37, getItem(Material.BOOK, null,null));
        inv.setItem(38, getItem(Material.BOOK, null,null));
        inv.setItem(39, getItem(Material.BOOK, null,null));
        inv.setItem(40, getItem(Material.BOOK, null,null));
        inv.setItem(41, getItem(Material.BOOK, null,null));
        inv.setItem(42, getItem(Material.BOOK, null,null));
        inv.setItem(43, getItem(Material.BOOK, null,null));
        inv.setItem(44, getItem(Material.BOOK, null,null));

        // Templates line 5
        inv.setItem(45, getItem(Material.BOOK, null,null));
        inv.setItem(46, getItem(Material.BOOK, null,null));
        inv.setItem(47, getItem(Material.BOOK, null,null));
        inv.setItem(48, getItem(Material.BOOK, null,null));
        inv.setItem(49, getItem(Material.BOOK, null,null));
        inv.setItem(50, getItem(Material.BOOK, null,null));
        inv.setItem(51, getItem(Material.BOOK, null,null));
        inv.setItem(52, getItem(Material.BOOK, null,null));
        inv.setItem(53, getItem(Material.BOOK, null,null));


        // top
        inv.setItem(0, getItem(Material.BARRIER, ChatColor.RED+"Back", null));
        inv.setItem(1, getItem(Material.GRAY_STAINED_GLASS_PANE, null,null));
        inv.setItem(2, getItem(Material.GRAY_STAINED_GLASS_PANE, null,null));
        inv.setItem(3, getItem(Material.PAPER, ChatColor.RED+"Soon",null));
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
