package org.rammex.chatplus.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.utils.SkullUtils;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.UUID;

public class adminpanel {

    static Chatplus plugin;




    public static void getadminpanel(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "Admin Panel");

        inv.setItem(11, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTU0Y2UxMTExYzdkNjFlOWZhMjM0YmY0NjU4YjJkNTI2ZTVjY2ExNmUxYjBmOGRmMjQ2NmMxMjFlZTA2Y2RlNyJ9fX0="), ChatColor.RED+"Chat Format"));
        inv.setItem(13, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE1MmY4MTcyNzY3MDZjMjMzYmM0NGZiY2Y1ZjI1ZGNlYWVhMzlkNWQzODQ0ZTkyMTVmOWQ0MDQ2ODA3ZmM2NCJ9fX0="), ChatColor.RED+"ScoreBoard"));
        inv.setItem(15, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFkZDRmZTRhNDI5YWJkNjY1ZGZkYjNlMjEzMjFkNmVmYTZhNmI1ZTdiOTU2ZGI5YzVkNTljOWVmYWIyNSJ9fX0="), ChatColor.RED+"OverAll"));

        player.openInventory(inv);
    }

    public static void chatformatpanel(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "Chat Format");

        inv.setItem(11, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE1MmY4MTcyNzY3MDZjMjMzYmM0NGZiY2Y1ZjI1ZGNlYWVhMzlkNWQzODQ0ZTkyMTVmOWQ0MDQ2ODA3ZmM2NCJ9fX0="),"Templates"));
        inv.setItem(13, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2VkMWFiYTczZjYzOWY0YmM0MmJkNDgxOTZjNzE1MTk3YmUyNzEyYzNiOTYyYzk3ZWJmOWU5ZWQ4ZWZhMDI1In19fQ=="),"SOON"));
        inv.setItem(15, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjA1MWRlNjdiM2RhZDYyMzc0NmNlZDU3MzNlOGJmY2UyYmZjMTRmNTU2OGE1MDc0MjY2YjJkZDQyNzQ1ZmI3YSJ9fX0="),"Change"));

        inv.setItem(18, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGI0YjhmMzIzYTE0Nzc2ZGQ4NTFmMTcwMDM3NTNlYzRlODA1YjliM2RhMzFlMjU0YjRkMjJjY2ZhNWVmZjE2YSJ9fX0="),"Back"));


        player.openInventory(inv);
    }

    public static void scoreboardpanel(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "ScoreBoard");

        inv.setItem(11, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE1MmY4MTcyNzY3MDZjMjMzYmM0NGZiY2Y1ZjI1ZGNlYWVhMzlkNWQzODQ0ZTkyMTVmOWQ0MDQ2ODA3ZmM2NCJ9fX0="),"Templates"));
        inv.setItem(13, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2VkMWFiYTczZjYzOWY0YmM0MmJkNDgxOTZjNzE1MTk3YmUyNzEyYzNiOTYyYzk3ZWJmOWU5ZWQ4ZWZhMDI1In19fQ=="),"SOON"));
        inv.setItem(15, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjA1MWRlNjdiM2RhZDYyMzc0NmNlZDU3MzNlOGJmY2UyYmZjMTRmNTU2OGE1MDc0MjY2YjJkZDQyNzQ1ZmI3YSJ9fX0="),"Change"));

        inv.setItem(18, getItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGI0YjhmMzIzYTE0Nzc2ZGQ4NTFmMTcwMDM3NTNlYzRlODA1YjliM2RhMzFlMjU0YjRkMjJjY2ZhNWVmZjE2YSJ9fX0="),"Back"));


        player.openInventory(inv);
    }

    public static ItemStack getItem(ItemStack material, String customName) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        it.setItemMeta(customM);
        return it;
    }









}
