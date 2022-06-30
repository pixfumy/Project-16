package me.pixfumy.project16.mixin;

import me.pixfumy.project16.structure.ConfiguredStructures;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
    @Inject(method="addDefaultUndergroundStructures",at=@At("TAIL"))
    private static void addStructures(GenerationSettings.Builder builder, CallbackInfo ci){
        ConfiguredStructures.init();
        builder.structureFeature(ConfiguredStructures.PRIDE);
    }

    @Inject(method="addOceanStructures",at=@At("TAIL"))
    private static void addStructures3(GenerationSettings.Builder builder, CallbackInfo ci){
        ConfiguredStructures.init();
        builder.structureFeature(ConfiguredStructures.TOWER);
    }
}
