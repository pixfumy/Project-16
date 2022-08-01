package me.pixfumy.project16.mixin;

import me.pixfumy.project16.structure.ConfiguredStructures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeCreator;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DefaultBiomeCreator.class)
public class DefaultBiomeCreatorMixin {
    @Redirect(method = "createDesert", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/GenerationSettings$Builder;structureFeature(Lnet/minecraft/world/gen/feature/ConfiguredStructureFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;", ordinal = 3))
    private static GenerationSettings.Builder addStructures(GenerationSettings.Builder builder2, ConfiguredStructureFeature<?, ?> structureFeature) {
        builder2.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_DESERT);
        builder2.structureFeature(ConfiguredStructures.TOWER);
        return null;
    }

    @Redirect(method = "createCrimsonForest", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/gen/feature/DefaultBiomeFeatures;addNetherMineables(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V"))
    private static void addNetherShipsCrimson(GenerationSettings.Builder builder) {
        builder.structureFeature(ConfiguredStructures.CRIMSON_NETHER_SHIP);
        DefaultBiomeFeatures.addNetherMineables(builder);
    }

    @Redirect(method = "createWarpedForest", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/gen/feature/DefaultBiomeFeatures;addNetherMineables(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V"))
    private static void addNetherShipsWarped(GenerationSettings.Builder builder) {
        builder.structureFeature(ConfiguredStructures.WARPED_NETHER_SHIP);
        DefaultBiomeFeatures.addNetherMineables(builder);
    }
}
