package io.waterwave.bridge;

import io.waterwave.bridge.intf.IBridge;

public class BridgeManager {

    private static IBridge INSTANCE;

    public static void setImplementation(IBridge bridge) {
        INSTANCE = bridge;
        INSTANCE.enable();
    }
  
    public static IBridge getImplementation() {
        return INSTANCE;
    }

}
