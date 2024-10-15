package walksy.dummymod.protection;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.world.LevelLoadingScreen;
import org.apache.commons.codec.digest.DigestUtils;
import org.lwjgl.system.MemoryUtil;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.List;

public class ProtectionHandler {

    public static ProtectionHandler PROTECTION = new ProtectionHandler();
    private boolean time = false;
    private int ticks = 0;

    protected List<String> awesomePeopleUUIDs = List.of(
        "EEC03A3E031AA13BF45997871E31F3890C686F2778EE5E65B17601037540590A", //Walksy
        "43A99EA24885A5DCC441B1D9A955A7B474F660E87FD34ECC0DFDA1ECDA4D1CC5", //Pcrit
        "4078274D5EA1F7EECACF8E7E698743F59F434840DEA5D61251F22E7DB4080BA6", //Awerial
        "6CC19CB980EC64905C4CD7E909DD598DE98A7F0E5456DA52F8E53B132101EC02"  //Quelchi
    );

    public void invokeLoadEvent()
    {
        ClientTickEvents.START_CLIENT_TICK.register(client ->
        {
            if (!(MinecraftClient.getInstance().currentScreen instanceof AntiPlayScreen))
            {
                MinecraftClient.getInstance().setScreen(new AntiPlayScreen());
                MinecraftClient.getInstance().keyboard.setClipboard(this.getHWID());
                this.time = true;
            }
            if (this.time)
            {
                this.ticks++;
                if (ticks > 300)
                {
                    this.crashGame();
                }
            }
        });
    }

    public boolean whitelisted()
    {
        return awesomePeopleUUIDs.contains(this.getHWID());
    }

    private void crashGame()
    {
        System.exit(0);
        MinecraftClient.getInstance().stop();
        MemoryUtil.memSet(0, 0, 1L); //just in case it somehow doesn't crash
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
