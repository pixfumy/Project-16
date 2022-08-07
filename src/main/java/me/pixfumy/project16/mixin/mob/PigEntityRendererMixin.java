package me.pixfumy.project16.mixin.mob;

import me.pixfumy.project16.CrownFeatureRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PigEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PigEntityRenderer.class)
public abstract class PigEntityRendererMixin extends LivingEntityRenderer {
    public PigEntityRendererMixin(EntityRenderDispatcher dispatcher, EntityModel model, float shadowRadius) {
        super(dispatcher, model, shadowRadius);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void addHelmetFeature(EntityRenderDispatcher entityRenderDispatcher, CallbackInfo ci) {
        this.addFeature(new CrownFeatureRenderer(((PigEntityRenderer) (Object) this), new PigEntityModel(0.5f), new Identifier("textures/models/armor/technoblade_crown_layer_1.png")));
    }
}
