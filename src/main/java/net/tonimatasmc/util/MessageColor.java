package net.tonimatasmc.util;

import main.serverstuff.ServerStuff;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class MessageColor {
    public static void sendToPlayer(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message
                .replaceAll("%player_deaths%", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                .replaceAll("%player_kills%", String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)))
                .replaceAll("%mob_kills%", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                .replaceAll("%fish_caught%", String.valueOf(player.getStatistic(Statistic.FISH_CAUGHT)))
                .replaceAll("%jumps%", String.valueOf(player.getStatistic(Statistic.JUMP)))
                .replaceAll("%mien_blocks%", String.valueOf(player.getStatistic(Statistic.MINE_BLOCK)))

                //Variables
                .replaceAll("%world%", player.getWorld().getName())
                .replaceAll("%xp%", String.valueOf(player.getExp()))
                .replaceAll("%player_uuid%", String.valueOf(player.getUniqueId()))
                .replaceAll("%player_name%", player.getName())
        ));
    }

    public static void sendToConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void sendToBroadcast(Player player, String message) {
        ServerStuff.getInstance().getServer().broadcastMessage(message
                .replaceAll("%player_deaths%", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                .replaceAll("%player_kills%", String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)))
                .replaceAll("%mob_kills%", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                .replaceAll("%fish_caught%", String.valueOf(player.getStatistic(Statistic.FISH_CAUGHT)))
                .replaceAll("%jumps%", String.valueOf(player.getStatistic(Statistic.JUMP)))
                .replaceAll("%mien_blocks%", String.valueOf(player.getStatistic(Statistic.MINE_BLOCK)))

                //Variables
                .replaceAll("%world%", player.getWorld().getName())
                .replaceAll("%xp%", String.valueOf(player.getExp()))
                .replaceAll("%player_uuid%", String.valueOf(player.getUniqueId()))
                .replaceAll("%player_name%", player.getName())
        );
    }
}
