package net.tonimatasmc;

import main.serverstuff.ServerStuff;
import main.serverstuff.yml.Messages;
import main.serverstuff.yml.Players;
import net.tonimatasmc.managers.CommandManager;
import net.tonimatasmc.managers.EventManager;
import net.tonimatasmc.managers.YMLManager;
import net.tonimatasmc.task.AnvilTask;
import net.tonimatasmc.util.PluginDescription;

public class TonimatasMC {
    public static void enable() {
        YMLManager.register();
        PluginDescription.register();
        CommandManager.register();
        EventManager.register();
        AnvilTask.register();
    }

    public static void disable() {
        ServerStuff.getInstance().reloadConfig();
        ServerStuff.getInstance().saveConfig();
        Messages.reloadMessages();
        Messages.saveMessages();
        Players.reloadPlayers();
        Players.savePlayers();
    }
}
