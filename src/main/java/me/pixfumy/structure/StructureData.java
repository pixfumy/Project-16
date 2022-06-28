package me.pixfumy.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;

import static me.pixfumy.project16.Project16.modid;

public class StructureData {
    public static final StructurePool TOWER_START_POOL;
    public static void init(){}
    static{
        TOWER_START_POOL = StructurePools.register(
                new StructurePool(
                        new Identifier(modid,"tower"),
                        new Identifier("empty"),
                        ImmutableList.of(Pair.of(StructurePoolElement.method_30434("project16:tower/tower"),1)),
                        StructurePool.Projection.RIGID
                )
        );
    }
}
