package me.pixfumy.project16.structure;

import me.pixfumy.project16.features.TowerFeature;
import net.minecraft.world.gen.feature.JigsawFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class Structures {
    public static final StructureFeature<StructurePoolFeatureConfig> TOWER;
    public static final StructureFeature<StructurePoolFeatureConfig> PRIDE;

    static {
        TOWER = new TowerFeature(StructurePoolFeatureConfig.CODEC,0,true,false);
        PRIDE = new JigsawFeature(StructurePoolFeatureConfig.CODEC,40,true,true);
    }
}
