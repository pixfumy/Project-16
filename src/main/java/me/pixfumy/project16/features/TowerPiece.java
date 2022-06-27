package me.pixfumy.project16.features;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import me.pixfumy.project16.Project16;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.LegacySinglePoolElement;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;

public class TowerPiece extends PoolStructurePiece {


    public static void init() { }

    static {
        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        Project16.TOWER_POOL,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new LegacySinglePoolElement("project16:tower"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }

    public TowerPiece(StructureManager structureManager_1, StructurePoolElement structurePoolElement_1, BlockPos blockPos_1, int int_1, BlockRotation blockRotation_1, BlockBox mutableIntBoundingBox_1) {
        super(Project16.TOWER_PIECE, structureManager_1, structurePoolElement_1, blockPos_1, int_1, blockRotation_1, mutableIntBoundingBox_1);
    }

    public TowerPiece(StructureManager manager, CompoundTag tag) {
        super(manager, tag, Project16.TOWER_PIECE);
    }
}
