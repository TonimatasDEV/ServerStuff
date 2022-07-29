package net.tonimatasmc;

import net.tonimatasmc.managers.CommandManager;
import net.tonimatasmc.util.PluginDescription;

public class TonimatasMC {
    public static void enable() {
        PluginDescription.register();
        CommandManager.register();

    }

    public static void disable() {

    }
}
