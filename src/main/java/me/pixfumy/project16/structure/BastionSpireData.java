package me.pixfumy.project16.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.Identifier;

public class BastionSpireData {
    public static void init(){}
    static {

        StructurePools.register(
                new StructurePool(
                        new Identifier("project16:bastion/spire/upper_towers"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.method_30435("project16:bastion/spire/upper_towers/upper_towers", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1)
                        ),
                        StructurePool.Projection.RIGID)
        );
        StructurePools.register(
                new StructurePool(
                        new Identifier("project16:bastion/spire/middle_towers"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.method_30435("project16:bastion/spire/middle_towers/middle_towers_1", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1)
                        ),
                        StructurePool.Projection.RIGID)
        );
        StructurePools.register(
                new StructurePool(new Identifier("project16:bastion/mobs/wither_skeleton"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.method_30434("project16:bastion/mobs/wither_skeleton"), 1)
                        ),
                        StructurePool.Projection.RIGID));
    }
}
