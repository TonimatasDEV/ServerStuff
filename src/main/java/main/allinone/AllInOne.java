package main.allinone;

import com.danizml.danizml;
import net.tonimatasmc.TonimatasMC;
import org.bukkit.plugin.java.JavaPlugin;

public final class AllInOne extends JavaPlugin {
    private static AllInOne INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        danizml.enable();
        TonimatasMC.enable();
    }

    @Override
    public void onDisable() {
        danizml.disable();
        TonimatasMC.disable();
    }

    public static AllInOne getInstance() {
        return INSTANCE;
    }
}
