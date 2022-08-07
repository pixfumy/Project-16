package me.pixfumy.project16.mixin.access;

import com.google.common.collect.ImmutableList;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(StructureProcessorLists.class)
public interface StructureProcessorListsAccess {
    @Invoker
    static StructureProcessorList invokeRegister(String id, ImmutableList<StructureProcessor> processorList) {
        throw new AssertionError();
    }
}
