package main.serverstuff;

import com.danizml.danizml;
import main.serverstuff.yml.Config;
import main.serverstuff.yml.Messages;
import net.tonimatasmc.TonimatasMC;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStuff extends JavaPlugin {
    private static ServerStuff INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Config.registerConfig();
        Messages.getMessages();
        TonimatasMC.enable();
        danizml.enable();
    }

    @Override
    public void onDisable() {
        TonimatasMC.disable();
        danizml.disable();
    }

    public static ServerStuff getInstance() {
        return INSTANCE;
    }
}
