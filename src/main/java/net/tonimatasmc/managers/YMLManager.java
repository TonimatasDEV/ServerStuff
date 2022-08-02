package net.tonimatasmc.managers;

import main.serverstuff.ServerStuff;
import main.serverstuff.yml.Config;
import main.serverstuff.yml.Messages;
import main.serverstuff.yml.Players;

public class YMLManager {
    public static void register() {
        Config.registerConfig();
        Messages.registerMessages();
        Players.registerPlayers();
    }

    public static void unregister() {
        ServerStuff.getInstance().saveConfig();
        Messages.saveMessages();
        Players.savePlayers();

        ServerStuff.getInstance().reloadConfig();
        Messages.reloadMessages();
        Players.reloadPlayers();
    }

    public static void reload() {
        ServerStuff.getInstance().reloadConfig();
        Messages.reloadMessages();
        Players.reloadPlayers();
    }
}
