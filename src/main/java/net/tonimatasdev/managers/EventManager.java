package net.tonimatasdev.managers;

import main.serverstuff.ServerStuff;
import net.tonimatasdev.events.onEntityDamage;
import net.tonimatasdev.events.onPlayerQuit;
import net.tonimatasdev.listener.RepairListener;

public class EventManager {
    public static void register() {
        ServerStuff.getInstance().getServer().getPluginManager().registerEvents(new onPlayerQuit(), ServerStuff.getInstance());
        ServerStuff.getInstance().getServer().getPluginManager().registerEvents(new onEntityDamage(), ServerStuff.getInstance());
        ServerStuff.getInstance().getServer().getPluginManager().registerEvents(new RepairListener(), ServerStuff.getInstance());
    }
}
