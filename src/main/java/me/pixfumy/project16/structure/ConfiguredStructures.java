package me.pixfumy.project16.structure;

import me.pixfumy.project16.Project16;
import me.pixfumy.project16.mixin.access.ConfiguredStructureFeaturesAccess;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class ConfiguredStructures {
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig,? extends StructureFeature<StructurePoolFeatureConfig>> TOWER;
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig,? extends StructureFeature<StructurePoolFeatureConfig>> PRIDE;

    public static void init(){}
    static {
        TOWER = ConfiguredStructureFeaturesAccess.invokeRegister(
                Project16.modid+":tower",
                Structures.TOWER.configure(
                        new StructurePoolFeatureConfig(()->StructureData.TOWER_START_POOL,1)
                )
        );
        PRIDE = ConfiguredStructureFeaturesAccess.invokeRegister(
                Project16.modid+":pride",
                Structures.PRIDE.configure(
                        new StructurePoolFeatureConfig(()->StructureData.PRIDE_START_POOL,5)
                )
        );
    }
}
