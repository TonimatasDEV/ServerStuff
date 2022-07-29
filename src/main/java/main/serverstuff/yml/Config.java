package main.serverstuff.yml;

import main.serverstuff.ServerStuff;

import java.io.File;

public class Config {
    public static void registerConfig() {
        File config = new File(ServerStuff.getInstance().getDataFolder(), "config.yml");

        if (!config.exists()) {
            ServerStuff.getInstance().getConfig().options().copyDefaults(true);
            ServerStuff.getInstance().saveConfig();
        }
    }
}
