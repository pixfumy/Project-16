package me.pixfumy.project16.structure;


import com.mojang.datafixers.util.Pair;
import me.pixfumy.project16.Project16;
import me.pixfumy.project16.mixin.access.ConfiguredStructureFeaturesAccess;
import me.pixfumy.project16.mixinterface.IStructurePoolFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.List;

public class ConfiguredStructures {
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig,? extends StructureFeature<StructurePoolFeatureConfig>> TOWER;
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig,? extends StructureFeature<StructurePoolFeatureConfig>> PRIDE;
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig,? extends StructureFeature<StructurePoolFeatureConfig>> CRIMSON_NETHER_SHIP;
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig,? extends StructureFeature<StructurePoolFeatureConfig>> WARPED_NETHER_SHIP;

    public static void init(){}

    static {
        TOWER = ConfiguredStructureFeaturesAccess.invokeRegister(
                Project16.modid+":tower",
                Structures.TOWER.configure(
                        new StructurePoolFeatureConfig(()->StructureData.TOWER_START_POOL,1)
                )
        );
        CRIMSON_NETHER_SHIP = ConfiguredStructureFeaturesAccess.invokeRegister(
                Project16.modid+":crimson_nether_ship",
                Structures.NETHER_SHIP.configure(
                        new StructurePoolFeatureConfig(()->StructureData.CRIMSON_NETHER_SHIP_START_POOL,1)
                )
        );
        WARPED_NETHER_SHIP = ConfiguredStructureFeaturesAccess.invokeRegister(
                Project16.modid+":warped_nether_ship",
                Structures.NETHER_SHIP.configure(
                        new StructurePoolFeatureConfig(()->StructureData.WARPED_NETHER_SHIP_START_POOL,1)
                )
        );
        PRIDE = ConfiguredStructureFeaturesAccess.invokeRegister(
                Project16.modid+":pride",
                Structures.PRIDE.configure(
                        ((IStructurePoolFeatureConfig)new StructurePoolFeatureConfig(()->StructureData.PRIDE_START_POOL,5))
                                .setLimitedStructurePoolElements(List.of(new Pair<>(List.of(StructureData.GAY_BRIDGE_ELEMENT),3)))
                )
        );
    }
}
