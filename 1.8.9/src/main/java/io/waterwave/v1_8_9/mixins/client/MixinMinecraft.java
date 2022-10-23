package io.waterwave.v1_8_9.mixins.client;

import io.waterwave.bridge.BridgeManager;
import io.waterwave.client.Client;
import io.waterwave.v1_8_9.bridge.BridgeImpl;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(method = "startGame()V", at = @At("HEAD"))
    public void impl$startGame(CallbackInfo ci) {
        BridgeManager.setImplementation(new BridgeImpl());
        Client.getInstance().init();
    }

}
