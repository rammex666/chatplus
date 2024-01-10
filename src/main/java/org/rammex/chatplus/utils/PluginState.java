package org.rammex.chatplus.utils;

import org.bukkit.entity.Player;

public class PluginState {
    private boolean waitingForChat = false;
    private Player playerWaiting;

    public boolean isWaitingForChat() {
        return waitingForChat;
    }

    public void setWaitingForChat(boolean waitingForChat) {
        this.waitingForChat = waitingForChat;
    }

    public Player getPlayerWaiting() {
        return playerWaiting;
    }

    public void setPlayerWaiting(Player playerWaiting) {
        this.playerWaiting = playerWaiting;
    }
}
