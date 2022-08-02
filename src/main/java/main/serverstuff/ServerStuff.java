package main.serverstuff;

import com.danizml.danizml;
import net.tonimatasmc.TonimatasMC;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStuff extends JavaPlugin {
    private static ServerStuff INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
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
