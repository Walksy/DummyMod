package walksy.dummymod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DummyMod implements ModInitializer {

    protected List<String> awesomePeopleUUIDs = List.of(
        "EEC03A3E031AA13BF45997871E31F3890C686F2778EE5E65B17601037540590A", //Walksy
        "");

    @Override
    public void onInitialize()
    {
        if (!awesomePeopleUUIDs.contains(this.getHWID()))
        {
            throw new RuntimeException("You are not on the awesome people list!!! Your HWID is: " + this.getHWID());
        }
    }

    public String getHWID() {
        String work = DigestUtils.sha256Hex(
            DigestUtils.sha256Hex(System.getProperty("user.name") +
                System.getenv("os") + System.getProperty("os.name") +
                System.getProperty("os.arch") + System.getenv("SystemRoot") +
                System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") +
                System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") +
                System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") +
                System.getenv("NUMBER_OF_PROCESSORS")));
        return work.toUpperCase();
    }
}
