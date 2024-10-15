package walksy.dummymod.protection;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import walksy.dummymod.DummyMod;

import java.awt.*;

public class AntiPlayScreen extends Screen {

    private final String[] messages = {"", "", ""};

    public AntiPlayScreen()
    {
        super(Text.literal("Lock Screen"));
        messages[0] = "You are not permitted (awesome enough) to use Walksy's mod: " + DummyMod.modName;
        messages[1] = "Your game will crash momentarily >⁓<";
        messages[2] = "Your UUID has been copied to clipboard <3";
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, context.getScaledWindowWidth(), context.getScaledWindowHeight(), 0, Color.BLACK.getRGB());
        context.getMatrices().push();
        context.drawText(
            this.client.textRenderer,
            messages[0],
            (context.getScaledWindowWidth() / 2) - (this.client.textRenderer.getWidth(messages[0]) / 2),
            context.getScaledWindowHeight() / 3,
            -1,
            true
        );
        context.drawText(
            this.client.textRenderer,
            messages[1],
            (context.getScaledWindowWidth() / 2) - (this.client.textRenderer.getWidth(messages[1]) / 2),
            context.getScaledWindowHeight() / 2,
            -1,
            true
        );
        context.drawText(
            this.client.textRenderer,
            messages[2],
            (context.getScaledWindowWidth() / 2) - (this.client.textRenderer.getWidth(messages[2]) / 2),
            (int)(context.getScaledWindowHeight() / 1.5),
            -1,
            true
        );
        context.getMatrices().pop();
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
    }

    @Override
    public void close() {

    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}
