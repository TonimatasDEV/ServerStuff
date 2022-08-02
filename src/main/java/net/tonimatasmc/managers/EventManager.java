package net.tonimatasmc.managers;

import main.serverstuff.ServerStuff;
import net.tonimatasmc.events.onPlayerQuit;
import net.tonimatasmc.listener.RepairListener;

public class EventManager {
    public static void register() {
        ServerStuff.getInstance().getServer().getPluginManager().registerEvents(new onPlayerQuit(), ServerStuff.getInstance());
        ServerStuff.getInstance().getServer().getPluginManager().registerEvents(new RepairListener(), ServerStuff.getInstance());
    }
}
