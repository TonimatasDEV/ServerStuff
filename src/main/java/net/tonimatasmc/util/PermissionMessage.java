package net.tonimatasmc.util;

import main.serverstuff.ServerStuff;
import org.bukkit.entity.Player;

public class PermissionMessage {
    public static void nonPermission(Player player) {
        if (ServerStuff.getInstance().getConfig().getBoolean("Config.Permission-error")) {
            MessageColor.sendToPlayer(player, ServerStuff.getInstance().getConfig().getString("Config.Permission-message"));
        }
    }
}
