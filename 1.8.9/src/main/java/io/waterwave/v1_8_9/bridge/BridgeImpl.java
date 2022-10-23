package io.waterwave.v1_8_9.bridge;

import io.waterwave.bridge.BridgeManager;
import io.waterwave.bridge.intf.IBridge;

public class BridgeImpl implements IBridge {

    @Override
    public void enable() {
        System.out.println("++ THE BRIDGE HAS BEEN ENABLED ++");
    }

}
