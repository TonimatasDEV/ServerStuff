package net.tonimatasdev;

import net.tonimatasdev.managers.CommandManager;
import net.tonimatasdev.managers.EventManager;
import net.tonimatasdev.managers.YMLManager;
import net.tonimatasdev.task.AnvilTask;
import net.tonimatasdev.util.PluginDescription;

public class TonimatasDEV {
    public static void enable() {
        YMLManager.register();
        PluginDescription.register();
        CommandManager.register();
        EventManager.register();
        AnvilTask.register();
    }

    public static void disable() {
        YMLManager.unregister();
    }
}
