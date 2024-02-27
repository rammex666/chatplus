package org.rammex.chatplus.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.rammex.chatplus.utils.SkullUtils;

import static org.rammex.chatplus.utils.ItemBuilder.getSimpleItem;

public class AdminPanel {

    public static void openAdminPanel(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Admin Panel");

        inventory.setItem(11, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTU0Y2UxMTExYzdkNjFlOWZhMjM0YmY0NjU4YjJkNTI2ZTVjY2ExNmUxYjBmOGRmMjQ2NmMxMjFlZTA2Y2RlNyJ9fX0="), ChatColor.RED + "Chat Format"));
        inventory.setItem(13, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE1MmY4MTcyNzY3MDZjMjMzYmM0NGZiY2Y1ZjI1ZGNlYWVhMzlkNWQzODQ0ZTkyMTVmOWQ0MDQ2ODA3ZmM2NCJ9fX0="), ChatColor.RED + "ScoreBoard"));
        inventory.setItem(15, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFkZDRmZTRhNDI5YWJkNjY1ZGZkYjNlMjEzMjFkNmVmYTZhNmI1ZTdiOTU2ZGI5YzVkNTljOWVmYWIyNSJ9fX0="), ChatColor.RED + "OverAll"));

        player.openInventory(inventory);
    }

    public static void openChatFormatPanel(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Chat Format");

        inventory.setItem(11, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE1MmY4MTcyNzY3MDZjMjMzYmM0NGZiY2Y1ZjI1ZGNlYWVhMzlkNWQzODQ0ZTkyMTVmOWQ0MDQ2ODA3ZmM2NCJ9fX0="), "Templates"));
        inventory.setItem(13, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2VkMWFiYTczZjYzOWY0YmM0MmJkNDgxOTZjNzE1MTk3YmUyNzEyYzNiOTYyYzk3ZWJmOWU5ZWQ4ZWZhMDI1In19fQ=="), "SOON"));
        inventory.setItem(15, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjA1MWRlNjdiM2RhZDYyMzc0NmNlZDU3MzNlOGJmY2UyYmZjMTRmNTU2OGE1MDc0MjY2YjJkZDQyNzQ1ZmI3YSJ9fX0="), "Change"));

        inventory.setItem(18, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5miW5lY3JhZnQubmV0L3RleHR1cmUvOGI0YjhmMzIzYTE0Nzc2ZGQ4NTFmMTcwMDM3NTNlYzRlODA1YjliM2RhMzFlMjU0YjRkMjJjY2ZhNWVmZjE2YSJ9fX0="), "Back"));

        player.openInventory(inventory);
    }

    public static void openScoreBoardPanel(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "ScoreBoard");

        inventory.setItem(11, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE1MmY4MTcyNzY3MDZjMjMzYmM0NGZiY2Y1ZjI1ZGNlYWVhMzlkNWQzODQ0ZTkyMTVmOWQ0MDQ2ODA3ZmM2NCJ9fX0="), "Templates"));
        inventory.setItem(13, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2VkMWFiYTczZjYzOWY0YmM0MmJkNDgxOTZjNzE1MTk3YmUyNzEyYzNiOTYyYzk3ZWJmOWU5ZWQ4ZWZhMDI1In19fQ=="), "SOON"));
        inventory.setItem(15, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjA1MWRlNjdiM2RhZDYyMzc0NmNlZDU3MzNlOGJmY2UyYmZjMTRmNTU2OGE1MDc0MjY2YjJkZDQyNzQ1ZmI3YSJ9fX0="), "Change"));

        inventory.setItem(18, getSimpleItem(SkullUtils.itemWithBase64(SkullUtils.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGI0YjhmMzIzYTE0Nzc2ZGQ4NTFmMTcwMDM3NTNlYzRlODA1YjliM2RhMzFlMjU0YjRkMjJjY2ZhNWVmZjE2YSJ9fX0="), "Back"));

        player.openInventory(inventory);
    }
}