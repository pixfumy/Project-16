package me.pixfumy.project16.mixinterface;

import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.List;

public interface IStructurePoolFeatureConfig {
    List<Pair<List<StructurePoolElement>, Integer>> getLimitedStructurePoolElements();
    StructurePoolFeatureConfig setLimitedStructurePoolElements(List<com.mojang.datafixers.util.Pair<List<StructurePoolElement>, Integer>> list);
}
