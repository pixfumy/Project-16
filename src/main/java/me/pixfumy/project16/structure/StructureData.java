package me.pixfumy.project16.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import me.pixfumy.project16.structure.processor.RepeatDownwardsProcessor;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.util.Identifier;

import static me.pixfumy.project16.Project16.modid;

public class StructureData {
    public static final StructurePool TOWER_START_POOL;
    public static final StructurePool PRIDE_START_POOL;

    static{
        TOWER_START_POOL = StructurePools.register(
                new StructurePool(
                        new Identifier(modid,"tower/start"),
                        new Identifier("empty"),
                        ImmutableList.of(Pair.of(StructurePoolElement.method_30434("project16:tower/zen_tower"),1),
                                Pair.of(StructurePoolElement.method_30434("project16:tower/one_block_tower"),1),
                                Pair.of(StructurePoolElement.method_30434("project16:tower/sword_tower"),1),
                                Pair.of(StructurePoolElement.method_30434("project16:tower/chaos_tower"),1)),
                        StructurePool.Projection.RIGID
                )
        );
        PRIDE_START_POOL = StructurePools.register(
                new StructurePool(
                        new Identifier(modid,"pride/start"),
                        new Identifier("empty"),
                        ImmutableList.of(Pair.of(StructurePoolElement.method_30434("project16:pride/gay_bridge"),1)),
                        StructurePool.Projection.RIGID
                )
        );
        StructurePools.register(
                new StructurePool(
                        new Identifier(modid,"pride/bridge"),
                        new Identifier("empty"),
                        ImmutableList.of(Pair.of(StructurePoolElement.method_30434("project16:pride/gay_bridge"),1)),
                        StructurePool.Projection.RIGID
                )
        );
        StructurePools.register(
                new StructurePool(
                        new Identifier(modid,"pride/pillars"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.method_30435("project16:util/downwards_repeat_3x3",new StructureProcessorList(ImmutableList.of(new RepeatDownwardsProcessor(new Identifier(modid,"pride/bi_pillar"))))),1),
                                Pair.of(StructurePoolElement.method_30435("project16:util/downwards_repeat_3x3",new StructureProcessorList(ImmutableList.of(new RepeatDownwardsProcessor(new Identifier(modid,"pride/trans_pillar"))))),1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }
}
