package me.pixfumy.project16.mixin.structure;

import me.pixfumy.project16.mixinterface.IStructurePoolGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(StructurePoolBasedGenerator.class)
public class StructurePoolBasedGeneratorMixin {
    @ModifyVariable(method = "method_30419",at=@At("STORE"))
    private static StructurePoolBasedGenerator.StructurePoolGenerator setStructurePoolFeatureConfig(StructurePoolBasedGenerator.StructurePoolGenerator structurePoolGenerator, DynamicRegistryManager dynamicRegistryManager, StructurePoolFeatureConfig structurePoolFeatureConfig){
        ((IStructurePoolGenerator)(Object)structurePoolGenerator).setStructurePoolFeatureConfig(structurePoolFeatureConfig);
        return structurePoolGenerator;
    }

}
