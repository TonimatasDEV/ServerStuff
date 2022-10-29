package net.tonimatasdev.constructor;

import net.tonimatasdev.commands.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerStuffCommandExecutor {
    private final CommandExecutor executor;

    public ServerStuffCommandExecutor() {
        executor = (sender, command, label, args) -> {
            switch (command.getName()) {
                case "speed" -> new SpeedCommand(isPlayer(sender), label, args);
                case "tpoffline" -> new TPOfflinePlayerCommand(isPlayer(sender), label, args);
                case "wb", "workbench" -> new WorkbenchCommand(isPlayer(sender), label, args);
                case "god" -> new GodModeCommand(isPlayer(sender), label, args);
                case "plugin" -> new EnableDisablePluginsCommand(isPlayer(sender), label, args);
            }



            return false;
        };
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    private static Player isPlayer(CommandSender sender) {
        assert sender instanceof Player;
        return (Player) sender;
    }
}
