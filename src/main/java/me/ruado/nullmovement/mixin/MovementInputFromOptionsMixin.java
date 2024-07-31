package me.ruado.nullmovement.mixin;

import me.ruado.nullmovement.config.NullMovementConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import me.ruado.nullmovement.NullMovement;
import org.spongepowered.asm.mixin.*;

@Mixin(MovementInputFromOptions.class)
public class MovementInputFromOptionsMixin extends MovementInput {
    @Final @Shadow
    private GameSettings gameSettings;

    private Minecraft mc = Minecraft.getMinecraft();

    @Unique
    private boolean lastForward;

    @Unique
    private boolean lastSideways;

    /**
     * @author ruado
     * @reason fixes
     */
    @Overwrite
    public void updatePlayerMoveState() {
        this.moveStrafe = 0.0F;
        this.moveForward = 0.0F;

        boolean forward = mc.gameSettings.keyBindForward.isKeyDown();
        boolean backward = mc.gameSettings.keyBindBack.isKeyDown();
        boolean left = mc.gameSettings.keyBindLeft.isKeyDown();
        boolean right = mc.gameSettings.keyBindRight.isKeyDown();
        if (forward && !backward) {
            this.lastForward = true;
        } else if (!forward && backward) {
            this.lastForward = false;
        }
        if (left && !right) {
            this.lastSideways = true;
        } else if (!left && right) {
            this.lastSideways = false;
        }

        if (NullMovement.config.enabled && NullMovementConfig.fixForward && forward && backward) {
            this.moveForward = getValue(this.lastForward);
        } else {
            if (this.gameSettings.keyBindForward.isKeyDown()) this.moveForward++;
            if (this.gameSettings.keyBindBack.isKeyDown()) this.moveForward--;
        }
        if (NullMovement.config.enabled && NullMovementConfig.fixStrafe && left && right) {
            this.moveStrafe = getValue(this.lastSideways);
        } else {
            if (this.gameSettings.keyBindLeft.isKeyDown()) this.moveStrafe++;
            if (this.gameSettings.keyBindRight.isKeyDown()) this.moveStrafe--;
        }

        this.jump = this.gameSettings.keyBindJump.isKeyDown();
        this.sneak = this.gameSettings.keyBindSneak.isKeyDown();

        if (this.sneak) {
            this.moveStrafe = (float)(this.moveStrafe * 0.3D);
            this.moveForward = (float)(this.moveForward * 0.3D);
        }
    }

    @Unique
    public float getValue(boolean lastPressedWasPositive) {
        return lastPressedWasPositive ? -1f : 1f;
    }
}