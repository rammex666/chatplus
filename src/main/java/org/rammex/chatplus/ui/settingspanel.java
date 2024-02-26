package org.rammex.chatplus.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.rammex.chatplus.events.PlayerMessages;
import org.rammex.chatplus.utils.SkullUtils;
import static org.rammex.chatplus.utils.ItemBuilder.getSimpleItem;

public class settingspanel {

    public static void getSettingsPanel(Player player){
        Inventory inv = Bukkit.createInventory(null, 54, "Settings Panel");

        if(hasPerm(player, "chatplus.admin")) {
            inv.setItem(53, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTRkNDliYWU5NWM3OTBjM2IxZmY1YjJmMDEwNTJhNzE0ZDYxODU0ODFkNWIxYzg1OTMwYjNmOTlkMjMyMTY3NCJ9fX0="), ChatColor.RED +"Admin Panel"));
        }
        if(PlayerMessages.playerChatList.contains(player)) {
            inv.setItem(20, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U2MjMyMTFiZGE1ZGQ1YWI5ZTc2MDMwZjg2YjFjNDczMGI5ODg3MjZlZWY2YTNhYjI4YWExYzFmN2Q4NTAifX19"), ChatColor.RED+"See Player messages"));
        } else {
            inv.setItem(20, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzI5OWVjNGQxOGEwODAwMzQzMjhiNjY3ZWZiOTVkNzA5M2QxOWI1YmUxYWM5MWI3MDAwZGYwZjE1ZWRkZjgwYSJ9fX0="), ChatColor.GREEN+"See Player messages"));
        }



        player.openInventory(inv);
    }

    private static Boolean hasPerm(Player player, String perm) {
        return player.hasPermission(perm);
    }


}
