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

public class Messages {
    public static FileConfiguration messages = null;
    public static File messagesFile = null;

    public static FileConfiguration getMessages() {
        if (Messages.messages == null) {
            Messages.reloadMessages();
        }return Messages.messages;
    }

    public static void reloadMessages() {
        if (Messages.messages == null) {
            Messages.messagesFile = new File(ServerStuff.getInstance().getDataFolder(), "messages.yml");
        }

        Messages.messages = YamlConfiguration.loadConfiguration(Messages.messagesFile);

        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(ServerStuff.getInstance().getResource("messages.yml")), StandardCharsets.UTF_8);

        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        Messages.messages.setDefaults(defConfig);
    }

    public static void saveMessages() {
        try {
            Messages.messages.save(Messages.messagesFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public static void registerMessages() {
        Messages.messagesFile = new File(ServerStuff.getInstance().getDataFolder(), "messages.yml");

        if (!Messages.messagesFile.exists()) {
            Messages.getMessages().options().copyDefaults(true);
            Messages.saveMessages();
        }
    }
}
