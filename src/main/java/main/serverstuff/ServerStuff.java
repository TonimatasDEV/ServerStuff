package main.serverstuff;

import com.danizml.danizml;
import net.tonimatasdev.TonimatasDEV;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStuff extends JavaPlugin {
    private static ServerStuff INSTANCE;

    public static ServerStuff getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;
        TonimatasDEV.enable();
        danizml.enable();
    }

    @Override
    public void onDisable() {
        danizml.disable();
        TonimatasDEV.disable();
    }
}
