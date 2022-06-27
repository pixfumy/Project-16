package me.pixfumy.project16.features;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class TowerFeature extends StructureFeature<StructurePoolFeatureConfig> {

    public TowerFeature(Codec<StructurePoolFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory() {
        return Start::new;
    }

    @Override
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long l, ChunkRandom chunkRandom, int i, int j, Biome biome, ChunkPos chunkPos, StructurePoolFeatureConfig featureConfig) {
        return chunkRandom.nextInt(150) == 0; // 1 in 150
    }

    public static class Start extends StructureStart<StructurePoolFeatureConfig> {
        Start(StructureFeature<StructurePoolFeatureConfig> feature, int x, int z, BlockBox box, int int_3, long seed) {
            super(feature, x, z, box, int_3, seed);
        }

        @Override
        public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int x, int z, Biome biome, StructurePoolFeatureConfig config) {
            BlockPos pos = new BlockPos(x * 16, 80, z * 16);

            boolean randomYPos = false;
            boolean calculateMaxYFromPiecePositions = false;

            TowerPiece.init();

            StructurePoolBasedGenerator.addPieces(config.startPool, config.size, TowerPiece::new, chunkGenerator, structureManager,
                    pos, children, random, calculateMaxYFromPiecePositions, randomYPos);

            setBoundingBoxFromChildren();
        }
    }
}