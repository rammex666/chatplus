package org.rammex.chatplus.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public static ItemStack getLoreItem(ItemStack material, String customName, String[] lore) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        if (lore != null) customM.setLore(java.util.Arrays.asList(lore));
        it.setItemMeta(customM);
        return it;
    }

    public static ItemStack getEnchantItem(ItemStack material, String customName,Boolean enchant) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        if (enchant) it.addEnchantment(org.bukkit.enchantments.Enchantment.DURABILITY, 1);
        it.setItemMeta(customM);
        return it;
    }

    public static ItemStack getSimpleItem(ItemStack material, String customName) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        it.setItemMeta(customM);
        return it;
    }

    public static ItemStack getSimpleMaterialItem(Material material, String customName) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        it.setItemMeta(customM);
        return it;
    }
    public static ItemStack getMaterialLoreItem(Material material, String customName, String[] lore) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        if (lore != null) customM.setLore(java.util.Arrays.asList(lore));
        it.setItemMeta(customM);
        return it;
    }
}
