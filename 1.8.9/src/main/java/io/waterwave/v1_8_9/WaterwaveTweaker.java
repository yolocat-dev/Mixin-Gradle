package io.waterwave.v1_8_9;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WaterwaveTweaker implements ITweaker {

    private final List<String> launchArgs = new ArrayList<>();

    @Override
    public final void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        this.launchArgs.addAll(args);

        final String VERSION = "--version";
        final String ASSET_DIR = "--assetsDir";
        final String GAME_DIR = "--gameDir";

        if(!args.contains(VERSION) && profile != null) {
            launchArgs.add(VERSION);
            launchArgs.add(profile);
        }

        if(!args.contains(ASSET_DIR) && assetsDir != null) {
            launchArgs.add(ASSET_DIR);
            launchArgs.add(assetsDir.toString());
        }

        if(!args.contains(GAME_DIR) && gameDir != null) {
            launchArgs.add(GAME_DIR);
            launchArgs.add(gameDir.toString());
        }
    }

    @Override
    public final void injectIntoClassLoader(LaunchClassLoader classLoader) {
        MixinBootstrap.init();

        MixinEnvironment environment = MixinEnvironment.getDefaultEnvironment();
        Mixins.addConfiguration("mixins.1.8.9.json");

        if(environment.getObfuscationContext() == null) {
            environment.setObfuscationContext("notch");
        }

        environment.setSide(MixinEnvironment.Side.CLIENT);
    }

    @Override
    public String getLaunchTarget() {
        return MixinBootstrap.getPlatform().getLaunchTarget();
    }

    @Override
    public String[] getLaunchArguments() {
        return launchArgs.toArray(new String[0]);
    }

}
