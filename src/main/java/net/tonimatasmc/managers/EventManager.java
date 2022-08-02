package net.tonimatasmc.managers;

import main.serverstuff.ServerStuff;
import net.tonimatasmc.events.onPlayerQuit;

public class EventManager {
    public static void register() {
        ServerStuff.getInstance().getServer().getPluginManager().registerEvents(new onPlayerQuit(), ServerStuff.getInstance());
    }
}
