package net.tonimatasmc.commands;

import main.serverstuff.ServerStuff;
import main.serverstuff.yml.Messages;
import net.tonimatasmc.util.MessageVariables;
import net.tonimatasmc.util.UsedMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("speed")) {
                if (args[0].equalsIgnoreCase("fly")) {
                    if (player.hasPermission("serverstuff.speed.fly")) {
                        if (args.length >= 2) {
                            if (args.length == 3) {
                                Player target = ServerStuff.getInstance().getServer().getPlayer(args[2]);

                                if (!args[1].equalsIgnoreCase("normal")) {
                                    target.setFlySpeed(Float.parseFloat(args[1]));

                                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.speedCommand.flySpeedOther"));
                                    MessageVariables.sendToPlayer(target, null, Messages.getMessages().getString("Messages.speedCommand.flySpeed"));
                                } else {
                                    target.setFlySpeed(0.1F);

                                    MessageVariables.sendToPlayer(target, null, Messages.getMessages().getString("Messages.speedCommand.flySpeed"));
                                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.speedCommand.flySpeedOther"));
                                }
                            } else {
                                if (!args[1].equalsIgnoreCase("normal")) {
                                    player.setFlySpeed(Float.parseFloat(args[1]));

                                    MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.speedCommand.flySpeed"));
                                } else {
                                    player.setFlySpeed(0.1F);
                                    MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.speedCommand.flySpeed"));
                                }
                            }
                        } else {
                            UsedMessages.syntaxError(player);
                        }
                    } else {
                        UsedMessages.nonPermission(player);
                    }
                } else if (args[0].equalsIgnoreCase("walk")) {
                    if (player.hasPermission("serverstuff.speed.walk")) {
                        if (args.length >= 2) {
                            if (args.length == 3) {
                                Player target = ServerStuff.getInstance().getServer().getPlayer(args[2]);

                                if (!args[1].equalsIgnoreCase("normal")) {
                                    target.setWalkSpeed(Float.parseFloat(args[1]));

                                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.speedCommand.walkSpeedOther"));
                                    MessageVariables.sendToPlayer(target, null, Messages.getMessages().getString("Messages.speedCommand.walkSpeed"));
                                } else {
                                    target.setWalkSpeed(0.2F);

                                    MessageVariables.sendToPlayer(target, null, Messages.getMessages().getString("Messages.speedCommand.walkSpeed"));
                                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.speedCommand.walkSpeedOther"));
                                }
                            } else {
                                if (!args[1].equalsIgnoreCase("normal")) {
                                    player.setWalkSpeed(Float.parseFloat(args[1]));

                                    MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.speedCommand.walkSpeed"));
                                } else {
                                    player.setWalkSpeed(0.1F);
                                    MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.speedCommand.walkSpeed"));
                                }
                            }
                        } else {
                            UsedMessages.syntaxError(player);
                        }
                    } else {
                        UsedMessages.nonPermission(player);
                    }
                } else if (args[0].equalsIgnoreCase("both")) {
                    if (player.hasPermission("serverstuff.speed.both")) {
                        if (args.length >= 2) {
                            if (args.length == 3) {
                                Player target = ServerStuff.getInstance().getServer().getPlayer(args[2]);

                                if (!args[1].equalsIgnoreCase("normal")) {
                                    target.setWalkSpeed(Float.parseFloat(args[1]));
                                    player.setFlySpeed(Float.parseFloat(args[1]));

                                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.speedCommand.bothSpeedOther"));
                                    MessageVariables.sendToPlayer(target, null, Messages.getMessages().getString("Messages.speedCommand.bothSpeed"));
                                } else {
                                    target.setWalkSpeed(0.2F);
                                    target.setFlySpeed(0.1F);

                                    MessageVariables.sendToPlayer(target, null, Messages.getMessages().getString("Messages.speedCommand.bothSpeed"));
                                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.speedCommand.bothSpeedOther"));
                                }
                            } else {
                                if (!args[1].equalsIgnoreCase("normal")) {
                                    player.setWalkSpeed(Float.parseFloat(args[1]));
                                    player.setFlySpeed(Float.parseFloat(args[1]));

                                    MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.speedCommand.bothSpeed"));
                                } else {
                                    player.setWalkSpeed(0.2F);
                                    player.setFlySpeed(0.1F);

                                    MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.speedCommand.bothSpeed"));
                                }
                            }
                        } else {
                            UsedMessages.syntaxError(player);
                        }
                    } else {
                        UsedMessages.nonPermission(player);
                    }
                }
        }return false;
    }
}
