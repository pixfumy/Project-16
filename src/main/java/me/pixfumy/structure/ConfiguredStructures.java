package me.pixfumy.structure;

import me.pixfumy.project16.Project16;
import me.pixfumy.project16.mixin.access.ConfiguredStructureFeaturesAccess;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class ConfiguredStructures {
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig,? extends StructureFeature<StructurePoolFeatureConfig>> TOWER;
    public static void init(){}
    static {
        TOWER = ConfiguredStructureFeaturesAccess.invokeRegister(
                Project16.modid+":tower",
                Structures.TOWER.configure(
                        new StructurePoolFeatureConfig(()->StructureData.TOWER_START_POOL,1)
                )
        );
    }
}
