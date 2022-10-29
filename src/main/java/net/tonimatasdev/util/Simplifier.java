package net.tonimatasdev.util;

import main.serverstuff.ServerStuff;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Simplifier {
    public static boolean playerHasPermission(String permission, Player player) {
        if (!player.hasPermission(permission)) {
            UsedMessages.nonPermission(player);
            return false;
        } else {
            return true;
        }
    }

    public static boolean argsNumberChecker(int argsLength, int minim, int maxim, Player player) {
        if (argsLength <= minim || argsLength >= maxim) {
            UsedMessages.syntaxError(player);
            return false;
        } else {
            return true;
        }
    }

    //public static boolean listContains(String string, String ... list) {
    //    return Arrays.asList(list).contains(string);
    //}

    public static Player getPlayer(String name) {
       return ServerStuff.getInstance().getServer().getPlayer(name);
    }

    public static Plugin getPlugin(String name) {
        return ServerStuff.getInstance().getServer().getPluginManager().getPlugin(name);
    }
}
