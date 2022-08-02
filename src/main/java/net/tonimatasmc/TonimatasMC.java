package net.tonimatasmc;

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
        AnvilTask.ColoredAnvils();
    }

    public static void disable() {

    }
}
