package pl.example.elomod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class EloScreen extends Screen {

    public EloScreen() {
        super(Text.translatable("screen.elomod.title"));
    }

    @Override
    protected void init() {
        int w = 120;
        int h = 20;
        int x = this.width / 2 - w / 2;
        int y = this.height / 2 - 30;

        addDrawableChild(ButtonWidget.builder(Text.literal("123"), button -> say("123"))
                .dimensions(x, y, w, h).build());

        addDrawableChild(ButtonWidget.builder(Text.literal("elo"), button -> say("elo"))
                .dimensions(x, y + 26, w, h).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("screen.elomod.close"), button -> close())
                .dimensions(x, y + 60, w, h).build());
    }

    private void say(String msg) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) {
            mc.player.sendMessage(Text.literal("[Elo Mod] Wybrano: " + msg), false);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, this.height / 2 - 55, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
