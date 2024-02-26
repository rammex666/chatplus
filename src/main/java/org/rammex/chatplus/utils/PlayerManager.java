package org.rammex.chatplus.utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    public List<Player> playerChatList;

    public PlayerManager() {
        this.playerChatList = new ArrayList<>();
    }


    public List<Player> getPlayerChatList() {
        return this.playerChatList;
    }
}
