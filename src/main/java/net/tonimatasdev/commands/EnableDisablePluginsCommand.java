package net.tonimatasdev.commands;

import main.serverstuff.ServerStuff;
import net.tonimatasdev.util.MessageVariables;
import net.tonimatasdev.util.Simplifier;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class EnableDisablePluginsCommand extends Simplifier {

    public EnableDisablePluginsCommand(Player player, String label, String[] args) {
        assert argsNumberChecker(args.length, 1, 1, player);

        if (args[0].equalsIgnoreCase("enable")) {
            assert playerHasPermission("serverstuff.pluginmanager", player);


            Plugin plugin = getPlugin(args[1]);
            if (plugin != null && !plugin.getName().equals("ServerStuff")) {
                ServerStuff.getInstance().getServer().getPluginManager().enablePlugin(plugin);
                MessageVariables.sendToPlayer(player, null, "&2[Success]: &7The plugin has been enabled.");
            } else {
                MessageVariables.sendToPlayer(player, null, "&4[Error]: &7You put a invalid plugin.");
            }
        }

        if (args[1].equalsIgnoreCase("disable")) {
            assert playerHasPermission("serverstuff.pluginmanager", player);

            Plugin plugin = getPlugin(args[1]);

            if (plugin != null && !plugin.getName().equals("ServerStuff")) {
                ServerStuff.getInstance().getServer().getPluginManager().disablePlugin(plugin);
                MessageVariables.sendToPlayer(player, null, "&2[Success]: &7The plugin has been disabled.");
            } else {
                MessageVariables.sendToPlayer(player, null, "&4[Error]: &7You put a invalid plugin.");
            }
        }
    }
}

