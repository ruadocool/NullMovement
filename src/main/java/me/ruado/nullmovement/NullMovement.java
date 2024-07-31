package me.ruado.nullmovement;

import me.ruado.nullmovement.config.NullMovementConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = NullMovement.MODID, name = NullMovement.NAME, version = NullMovement.VERSION)
public class NullMovement {

    public static final String MODID = "nullmovement";
    public static final String NAME = "Null Movement";
    public static final String VERSION = "0.1";
    @Mod.Instance(MODID)
    public static NullMovement INSTANCE;
    public static NullMovementConfig config;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new NullMovementConfig();
    }
}
