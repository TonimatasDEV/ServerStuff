package com.danizml.core;


import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;


public class Variables {
    public static Map<Player, BukkitTask> tasks = new HashMap<>();

    public static void sendBroadcastMessage(Player player, String message) {

        //Variables
        Bukkit.broadcastMessage(message.replaceAll("%xp%", String.valueOf(player.getExp())));
        Bukkit.broadcastMessage(message.replaceAll("%player_uuid%", String.valueOf(player)));
        Bukkit.broadcastMessage(message.replaceAll("%player_name%", String.valueOf(player.getName())));
        Bukkit.broadcastMessage(message.replaceAll("%world%", String.valueOf(player.getWorld())));

        //Statistic
        Bukkit.broadcastMessage(message.replaceAll("%player_kills%", String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS))));
        Bukkit.broadcastMessage(message.replaceAll("%player_deaths%", String.valueOf(player.getStatistic(Statistic.DEATHS))));
        Bukkit.broadcastMessage(message.replaceAll("%mob_kills%", String.valueOf(player.getStatistic(Statistic.MOB_KILLS))));
    }
}
