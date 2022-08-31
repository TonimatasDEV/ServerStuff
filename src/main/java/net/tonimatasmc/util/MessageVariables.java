package net.tonimatasmc.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class MessageVariables {
    public static void sendToPlayer(Player player, Player target, String message) {
        if (player != null) {
            String phase = message

                    //Stats
                    //.replaceAll("%player_deaths%", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                    //.replaceAll("%player_kills%", String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)))
                    //.replaceAll("%mob_kills%", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                    //.replaceAll("%fish_caught%", String.valueOf(player.getStatistic(Statistic.FISH_CAUGHT)))
                    //.replaceAll("%jumps%", String.valueOf(player.getStatistic(Statistic.JUMP)))
                    //.replaceAll("%mien_blocks%", String.valueOf(player.getStatistic(Statistic.MINE_BLOCK)))

                    //Variables
                    .replaceAll("%world%", player.getWorld().getName())
                    .replaceAll("%xp%", String.valueOf(player.getExp()))
                    .replaceAll("%player_uuid%", String.valueOf(player.getUniqueId()))
                    .replaceAll("%player_name%", player.getName())
                    .replaceAll("%both_speed%", String.valueOf(player.getFlySpeed()))
                    .replaceAll("%walk_speed%", String.valueOf(player.getWalkSpeed()))
                    .replaceAll("%fly_speed%", String.valueOf(player.getFlySpeed()));

            if (target != null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', phase

                        //Stats
                        //.replaceAll("%player_deaths_other%", String.valueOf(target.getStatistic(Statistic.DEATHS)))
                        //.replaceAll("%player_kills_other%", String.valueOf(target.getStatistic(Statistic.PLAYER_KILLS)))
                        //.replaceAll("%mob_kills_other%", String.valueOf(target.getStatistic(Statistic.MOB_KILLS)))
                        //.replaceAll("%fish_caught_other%", String.valueOf(target.getStatistic(Statistic.FISH_CAUGHT)))
                        //.replaceAll("%jumps_other%", String.valueOf(target.getStatistic(Statistic.JUMP)))
                        //.replaceAll("%mien_blocks%_other", String.valueOf(target.getStatistic(Statistic.MINE_BLOCK)))

                        //Variables
                        .replaceAll("%world_other%", target.getWorld().getName())
                        .replaceAll("%xp_other%", String.valueOf(target.getExp()))
                        .replaceAll("%player_uuid_other%", String.valueOf(target.getUniqueId()))
                        .replaceAll("%player_name_other%", target.getName())
                        .replaceAll("%both_speed_other%", String.valueOf(target.getFlySpeed()))
                        .replaceAll("%walk_speed_other%", String.valueOf(target.getWalkSpeed()))
                        .replaceAll("%fly_speed_other%", String.valueOf(target.getFlySpeed()))
                ));
            } else {
                player.sendMessage(phase);
            }
        } else if (target != null) {
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', message

                    //Stats
                    //.replaceAll("%player_deaths_other%", String.valueOf(target.getStatistic(Statistic.DEATHS)))
                    //.replaceAll("%player_kills_other%", String.valueOf(target.getStatistic(Statistic.PLAYER_KILLS)))
                    //.replaceAll("%mob_kills_other%", String.valueOf(target.getStatistic(Statistic.MOB_KILLS)))
                    //.replaceAll("%fish_caught_other%", String.valueOf(target.getStatistic(Statistic.FISH_CAUGHT)))
                    //.replaceAll("%jumps_other%", String.valueOf(target.getStatistic(Statistic.JUMP)))
                    //.replaceAll("%mien_blocks%_other", String.valueOf(target.getStatistic(Statistic.MINE_BLOCK)))

                    //Variables
                    .replaceAll("%world_other%", target.getWorld().getName())
                    .replaceAll("%xp_other%", String.valueOf(target.getExp()))
                    .replaceAll("%player_uuid_other%", String.valueOf(target.getUniqueId()))
                    .replaceAll("%player_name_other%", target.getName())
                    .replaceAll("%both_speed_other%", String.valueOf(target.getFlySpeed()))
                    .replaceAll("%walk_speed_other%", String.valueOf(target.getWalkSpeed()))
                    .replaceAll("%fly_speed_other%", String.valueOf(target.getFlySpeed()))
            ));
        }
    }

    public static void sendToConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void sendToBroadcast(Player player, Player target, String message) {
        if (player != null) {
            String phase = message

                    //Stats
                    //.replaceAll("%player_deaths%", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                    //.replaceAll("%player_kills%", String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)))
                    //.replaceAll("%mob_kills%", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                    //.replaceAll("%fish_caught%", String.valueOf(player.getStatistic(Statistic.FISH_CAUGHT)))
                    //.replaceAll("%jumps%", String.valueOf(player.getStatistic(Statistic.JUMP)))
                    //.replaceAll("%mien_blocks%", String.valueOf(player.getStatistic(Statistic.MINE_BLOCK)))

                    //Variables
                    .replaceAll("%world%", player.getWorld().getName())
                    .replaceAll("%xp%", String.valueOf(player.getExp()))
                    .replaceAll("%player_uuid%", String.valueOf(player.getUniqueId()))
                    .replaceAll("%player_name%", player.getName())
                    .replaceAll("%both_speed%", String.valueOf(player.getFlySpeed()))
                    .replaceAll("%walk_speed%", String.valueOf(player.getWalkSpeed()))
                    .replaceAll("%fly_speed%", String.valueOf(player.getFlySpeed()));

            if (target != null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', phase

                        //Stats
                        //.replaceAll("%player_deaths_other%", String.valueOf(target.getStatistic(Statistic.DEATHS)))
                        //.replaceAll("%player_kills_other%", String.valueOf(target.getStatistic(Statistic.PLAYER_KILLS)))
                        //.replaceAll("%mob_kills_other%", String.valueOf(target.getStatistic(Statistic.MOB_KILLS)))
                        //.replaceAll("%fish_caught_other%", String.valueOf(target.getStatistic(Statistic.FISH_CAUGHT)))
                        //.replaceAll("%jumps_other%", String.valueOf(target.getStatistic(Statistic.JUMP)))
                        //.replaceAll("%mien_blocks%_other", String.valueOf(target.getStatistic(Statistic.MINE_BLOCK)))

                        //Variables
                        .replaceAll("%world_other%", target.getWorld().getName())
                        .replaceAll("%xp_other%", String.valueOf(target.getExp()))
                        .replaceAll("%player_uuid_other%", String.valueOf(target.getUniqueId()))
                        .replaceAll("%player_name_other%", target.getName())
                        .replaceAll("%both_speed_other%", String.valueOf(target.getFlySpeed()))
                        .replaceAll("%walk_speed_other%", String.valueOf(target.getWalkSpeed()))
                        .replaceAll("%fly_speed_other%", String.valueOf(target.getFlySpeed()))
                ));
            } else {
                player.sendMessage(phase);
            }
        } else if (target != null) {
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', message

                    //Stats
                    //.replaceAll("%player_deaths_other%", String.valueOf(target.getStatistic(Statistic.DEATHS)))
                    //.replaceAll("%player_kills_other%", String.valueOf(target.getStatistic(Statistic.PLAYER_KILLS)))
                    //.replaceAll("%mob_kills_other%", String.valueOf(target.getStatistic(Statistic.MOB_KILLS)))
                    //.replaceAll("%fish_caught_other%", String.valueOf(target.getStatistic(Statistic.FISH_CAUGHT)))
                    //.replaceAll("%jumps_other%", String.valueOf(target.getStatistic(Statistic.JUMP)))
                    //.replaceAll("%mien_blocks%_other", String.valueOf(target.getStatistic(Statistic.MINE_BLOCK)))

                    //Variables
                    .replaceAll("%world_other%", target.getWorld().getName())
                    .replaceAll("%xp_other%", String.valueOf(target.getExp()))
                    .replaceAll("%player_uuid_other%", String.valueOf(target.getUniqueId()))
                    .replaceAll("%player_name_other%", target.getName())
                    .replaceAll("%both_speed_other%", String.valueOf(target.getFlySpeed()))
                    .replaceAll("%walk_speed_other%", String.valueOf(target.getWalkSpeed()))
                    .replaceAll("%fly_speed_other%", String.valueOf(target.getFlySpeed()))
            ));
        }
    }
}
