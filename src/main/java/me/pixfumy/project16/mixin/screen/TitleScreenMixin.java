package me.pixfumy.project16.mixin.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiConsumer;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    @Mutable
    @Shadow @Final private boolean isMinceraft;

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "<init>()V", at = @At("TAIL"))
    private void setMinceraftFalse(CallbackInfo ci) {
        this.isMinceraft = false;
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/TitleScreen;method_29343(IILjava/util/function/BiConsumer;)V"))
    private void drawProject16Title(TitleScreen instance, int i, int j, BiConsumer biConsumer, MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.method_29343(this.width/2 - 120, 30, (integer, integer2) -> {
            this.drawTexture(matrices, integer, integer2, 0, 0, 173, 55);
            this.drawTexture(matrices, integer + 129, integer2 + 4, 13, 55, 150, 52);
        });
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/TitleScreen;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIFFIIII)V"))
    private void drawEdition(MatrixStack matrices, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight) {
        TitleScreen.drawTexture(matrices, this.width / 2 - 145, 80, 0.0f, 0.0f, 173, 16, 173, 16);
    }
}
