package me.ruado.nullmovement.config;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.TickEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import me.ruado.nullmovement.NullMovement;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;

public class NullMovementConfig extends Config {
    @Switch(name = "Fix Move Forward", size = OptionSize.DUAL)
    public static boolean fixForward = false;

    @Switch(name = "Fix Move Strafe", size = OptionSize.DUAL)
    public static boolean fixStrafe = false;

    public NullMovementConfig() {
        super(new Mod(NullMovement.NAME, ModType.UTIL_QOL), NullMovement.MODID + ".json");
        initialize();
        EventManager.INSTANCE.register(this);
    }
}