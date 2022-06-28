package me.pixfumy.project16.mixin.access;

import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ConfiguredStructureFeatures.class)
public interface ConfiguredStructureFeaturesAccess {
    @Invoker
    static <FC extends FeatureConfig, F extends StructureFeature<FC>> ConfiguredStructureFeature<FC, F> invokeRegister(String id, ConfiguredStructureFeature<FC, F> configuredStructureFeature){
        throw new AssertionError();
    }
}
