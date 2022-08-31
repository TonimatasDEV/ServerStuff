package main.serverstuff.yml;

import main.serverstuff.ServerStuff;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Players {
    private static FileConfiguration players = null;
    private static File playersFile = null;

    public static FileConfiguration getPlayers() {
        if (players == null) {
            reloadPlayers();
        }

        return players;
    }

    public static void reloadPlayers() {
        if (players == null) {
            playersFile = new File(ServerStuff.getInstance().getDataFolder(), "players.yml");
        }

        players = YamlConfiguration.loadConfiguration(playersFile);
        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(ServerStuff.getInstance().getResource("players.yml")), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        players.setDefaults(defConfig);
    }

    public static void savePlayers() {
        try {
            players.save(playersFile);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void registerPlayers() {
        playersFile = new File(ServerStuff.getInstance().getDataFolder(), "players.yml");

        if (!playersFile.exists()) {
            getPlayers().options().copyDefaults(true);
            savePlayers();
        }
    }
}
