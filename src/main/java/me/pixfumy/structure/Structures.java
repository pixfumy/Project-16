package me.pixfumy.structure;

import net.minecraft.world.gen.feature.JigsawFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class Structures {
    public static final StructureFeature<StructurePoolFeatureConfig> TOWER;
    public static void init(){}
    static {
        TOWER = new JigsawFeature(StructurePoolFeatureConfig.CODEC,0,true,true);
    }
}
