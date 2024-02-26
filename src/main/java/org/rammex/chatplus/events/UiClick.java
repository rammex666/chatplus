package org.rammex.chatplus.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.ui.adminpanel;
import org.rammex.chatplus.utils.PlayerManager;
import org.rammex.chatplus.utils.PluginState;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import static org.rammex.chatplus.utils.ColorUtil.hex;
import static org.rammex.chatplus.utils.ItemBuilder.getMaterialLoreItem;

public class UiClick implements Listener {
    Chatplus plugin;

    public UiClick(Chatplus plugin) {
        this.plugin = plugin;
    }
    private final PluginState pluginState = new PluginState();

    private final PlayerManager playerManager = new PlayerManager();



    @EventHandler
    public void Uiclick(InventoryClickEvent e){
        final Inventory inventory = e.getInventory();
        final Player whoClicked = (Player) e.getWhoClicked();
        final String title = e.getView().getTitle();
        ItemStack current = e.getCurrentItem();
        if (title.equalsIgnoreCase("Admin Panel")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if(current.getItemMeta().getDisplayName().equals(ChatColor.RED+"Chat Format")){
                whoClicked.closeInventory();
                adminpanel.chatformatpanel(whoClicked);
            }
            if(current.getItemMeta().getDisplayName().equals(ChatColor.RED+"ScoreBoard")){
                whoClicked.closeInventory();
                adminpanel.scoreboardpanel(whoClicked);
            }
        }
        if (title.equalsIgnoreCase("Chat Format")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if(current.getItemMeta().getDisplayName().equals("Templates")){
                whoClicked.closeInventory();
                tmpltctft(whoClicked);
            }
            if(current.getItemMeta().getDisplayName().equals("Change")){
                whoClicked.closeInventory();
                whoClicked.sendMessage(ChatColor.YELLOW +"Please enter the new chat format in the chat");
                pluginState.setWaitingForChat(true);
                pluginState.setPlayerWaiting((Player) whoClicked);
            }
        }
        if (title.equalsIgnoreCase("ScoreBoard")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
        }
        if (title.equalsIgnoreCase("Settings Panel")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if(current.getItemMeta().getDisplayName().equals(ChatColor.RED+"Admin Panel")){
                whoClicked.closeInventory();
                adminpanel.getadminpanel(whoClicked);
            }
            if(current.getItemMeta().getDisplayName().equals(ChatColor.RED+"See Player messages")){
                if(playerManager.getPlayerChatList().contains(whoClicked)){
                    playerManager.getPlayerChatList().remove(whoClicked);
                    whoClicked.sendMessage(ChatColor.GREEN +"You will now see player messages");
                }
                whoClicked.closeInventory();
            }
            if(current.getItemMeta().getDisplayName().equals(ChatColor.GREEN+"See Player messages")){
                if(!playerManager.getPlayerChatList().contains(whoClicked)){
                    playerManager.getPlayerChatList().add(whoClicked);
                    whoClicked.sendMessage(ChatColor.RED +"You will no longer see player messages");
                }
                whoClicked.closeInventory();
            }
        }
        if (title.equalsIgnoreCase("Chat Format Templates")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if(current.getType() == Material.BOOK){
                ConfigurationSection templatesSection = plugin.getct().getConfigurationSection("templates");
                for (String templateName : templatesSection.getKeys(false)) {
                    String titlee = ChatColor.stripColor(templatesSection.getString(templateName + ".title"));
                    String ctf = templatesSection.getString(templateName + ".chatformat");

                    if (titlee != null && titlee.equalsIgnoreCase(current.getItemMeta().getDisplayName())) {
                        plugin.getConfig().set("chatformat.format", ctf);
                        plugin.saveConfig();
                        plugin.reloadConfig();
                        whoClicked.closeInventory();
                        whoClicked.sendMessage(ChatColor.GREEN +"Chat format set to -> " + ctf);
                        break;
                    }
                }
            }
            if(current.getItemMeta().getDisplayName().equals(ChatColor.RED+"Back")){
                whoClicked.closeInventory();
                adminpanel.chatformatpanel(whoClicked);
            }
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String lang= this.plugin.getConfig().getString("lang");
        Player player = event.getPlayer();
        if (pluginState.isWaitingForChat() && player.equals(pluginState.getPlayerWaiting())) {
            if(lang.equals("en")){
                player.sendMessage(hex(this.plugin.geten().getString("succesmessage.formatchange")+ event.getMessage()));
            }
            if(lang.equals("fr")){
                player.sendMessage(hex(this.plugin.getfr().getString("succesmessage.formatchange")+ event.getMessage()));
            }
            if(lang.equals("de")){
                player.sendMessage(hex(this.plugin.getde().getString("succesmessage.formatchange")+ event.getMessage()));
            }
            pluginState.setWaitingForChat(false);
            pluginState.setPlayerWaiting(null);
            plugin.getConfig().set("chatformat.format", event.getMessage().toString());
            plugin.saveConfig();
            plugin.reloadConfig();
            event.setCancelled(true);
        }
    }

    public void tmpltctft(Player player) {
        plugin.getLogger().info("Opening Chat Format Templates inventory for player: " + player.getName());
        Inventory inv = Bukkit.createInventory(null, 54, "Chat Format Templates");

        generateItems(inv);

        // top
        inv.setItem(0, getMaterialLoreItem(Material.BARRIER, ChatColor.RED + "Back", null));
        inv.setItem(1, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(2, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(4, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(5, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(6, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(7, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(8, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));


        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(hex("#11B186&l&nActual Display Name"));
        List<String> lore = Collections.singletonList(hex(plugin.getConfig().getString("chatformat.format")).toString());
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(3,itemStack);


        player.openInventory(inv);
    }


    public void generateItems(Inventory inv) {
        Integer n = 0;
        ConfigurationSection templatesSection = plugin.getct().getConfigurationSection("templates");


        if (templatesSection != null) {
            plugin.getLogger().info("Number of templates: " + templatesSection.getKeys(false).size());

            for (String templateName : templatesSection.getKeys(false)) {
                n += 1;

                String title = templatesSection.getString(templateName + ".title");
                List<String> lore = templatesSection.getStringList(templateName + ".lore");

                String ctf = templatesSection.getString(templateName + ".chatformat");
                if (Objects.equals(plugin.getConfig().getString("chatformat.format"), ctf)) {
                    ItemStack itemStack = new ItemStack(Material.ENCHANTED_BOOK);
                    ItemMeta itemMeta = itemStack.getItemMeta();

                    if (title != null) {
                        itemMeta.setDisplayName(hex(title));
                    }

                    if (lore != null && !lore.isEmpty()) {
                        itemMeta.setLore(Collections.singletonList(hex(lore.toString())));
                    }

                    itemStack.setItemMeta(itemMeta);

                    inv.setItem(8 + n, itemStack);

                    plugin.getLogger().info("Item added ctf - Title: " + title + ", Lore: " + lore);
                } else{
                    ItemStack itemStack = new ItemStack(Material.BOOK);
                    ItemMeta itemMeta = itemStack.getItemMeta();

                    if (title != null) {
                        itemMeta.setDisplayName(hex(title));
                    }

                    if (lore != null && !lore.isEmpty()) {
                        itemMeta.setLore(Collections.singletonList(hex(lore.toString())));
                    }

                    itemStack.setItemMeta(itemMeta);

                    inv.setItem(8 + n, itemStack);

                    plugin.getLogger().info("Item added no ctf - Title: " + title + ", Lore: " + lore);
                }

            }
        } else{
            plugin.getLogger().info("null");
        }
    }
}
