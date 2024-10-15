package walksy.dummymod;

import net.fabricmc.api.ModInitializer;
import walksy.dummymod.protection.ProtectionHandler;

public class DummyMod implements ModInitializer {

    public static String modName = "DummyModName";

    @Override
    public void onInitialize()
    {
        if (!ProtectionHandler.PROTECTION.whitelisted()) {
            ProtectionHandler.PROTECTION.invokeLoadEvent();
        }
    }
}
