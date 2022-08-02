package net.tonimatasmc.commands;

import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import main.serverstuff.ServerStuff;
import main.serverstuff.yml.Players;
import net.tonimatasmc.util.MessageVariables;
import net.tonimatasmc.util.UsedMessages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPOfflinePlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("tpoffline")) {
            if (args.length == 1) {
                if (player.hasPermission("serverstuff.tpoffline")) {
                    if (Players.getPlayers().getConfigurationSection(args[0]) != null) {
                        if (ServerStuff.getInstance().getServer().getPlayer(args[0]).isOnline()) {
                            World world = ServerStuff.getInstance().getServer().getWorld(Players.getPlayers().get(args[0] + ".lastLocation").toString().split("-")[0]);

                            int positionX = Integer.parseInt(Players.getPlayers().get(args[0] + ".lastLocation").toString().split("-")[1]);
                            int positionY = Integer.parseInt(Players.getPlayers().get(args[0] + ".lastLocation").toString().split("-")[2]);
                            int positionZ = Integer.parseInt(Players.getPlayers().get(args[0] + ".lastLocation").toString().split("-")[3]);

                            player.teleport(new Location(world, positionX, positionY, positionZ));

                            MessageVariables.sendToPlayer(player, null, "&2[Successfully]: &fTeleported to " + Players.getPlayers().get(args[0] + ".lastLocation").toString().replaceAll("-", " "));
                        } else {
                            MessageVariables.sendToPlayer(player, null, "&4[Error]: &fThe player is online.");
                        }
                    } else {
                        MessageVariables.sendToPlayer(player, null, "&4[Error]: &fThe player never entered your server.");
                    }
                } else {
                    UsedMessages.nonPermission(player);
                }
            } else {
                UsedMessages.syntaxError(player);
            }
        }

        return false;
    }
}
