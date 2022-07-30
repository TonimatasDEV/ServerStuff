package net.tonimatasmc.util;

import main.serverstuff.ServerStuff;
import main.serverstuff.yml.Messages;
import org.bukkit.entity.Player;

public class UsedMessages {
    public static void nonPermission(Player player) {
        if (ServerStuff.getInstance().getConfig().getBoolean("Config.Permission-error")) {
            MessageVariables.sendToPlayer(player, null, ServerStuff.getInstance().getConfig().getString("Config.Permission-message"));
        }
    }

    public static void syntaxError(Player player) {
        MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.SyntaxError"));

    }
}
