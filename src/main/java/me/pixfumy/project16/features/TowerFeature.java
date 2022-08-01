package me.pixfumy.project16.features;

import com.mojang.serialization.Codec;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.JigsawFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.lwjgl.system.CallbackI;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

public class TowerFeature extends JigsawFeature {
    private final int structureStartY_;
    private final boolean field_25836_;
    private final boolean surface_;
    public TowerFeature(Codec<StructurePoolFeatureConfig> codec, int structureStartY, boolean bl, boolean surface) {
        super(codec, structureStartY, bl, surface);
        this.structureStartY_ = structureStartY;
        this.field_25836_ = bl;
        this.surface_ = surface;
    }

    @Override
    public StructureFeature.StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory() {
        return (feature, chunkX, chunkZ, boundingBox, references, seed) -> new Start(this, chunkX, chunkZ, boundingBox, references, seed);
    }

    public static class Start
            extends MarginedStructureStart<StructurePoolFeatureConfig> {
        private final TowerFeature towerFeature;

        public Start(TowerFeature feature, int chunkX, int chunkZ, BlockBox boundingBox, int references, long seed) {
            super(feature, chunkX, chunkZ, boundingBox, references, seed);
            this.towerFeature = (TowerFeature) feature;
        }

        @Override
        public void init(DynamicRegistryManager dynamicRegistryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, int i, int j, Biome biome, StructurePoolFeatureConfig structurePoolFeatureConfig) {
            StructurePools.initDefaultPools();
            int k = (i << 4) + 7;
            int l = (j << 4) + 7;
            int m = 0;
            int h1, h2, h3, h4;
            Heightmap.Type heightMap;
            if (biome.getCategory() == Biome.Category.OCEAN) {
                heightMap = Heightmap.Type.OCEAN_FLOOR_WG;
            } else if (biome.getCategory() == Biome.Category.DESERT) {
                heightMap = Heightmap.Type.WORLD_SURFACE_WG;
                h1 = chunkGenerator.getHeightInGround(k + 5, l + 5, heightMap);
                h2 = chunkGenerator.getHeightInGround(k - 5, l + 5, heightMap);
                h3 = chunkGenerator.getHeightInGround(k + 5, l - 5, heightMap);
                h4 = chunkGenerator.getHeightInGround(k - 5, l - 5, heightMap);
                m = Math.min(Math.min(Math.min(h1, h2), Math.min(h3, h4)), m);
                m -= this.random.nextInt(2);
            } else {
                return;
            }
            m += chunkGenerator.getHeightInGround(k, l, heightMap);
            BlockPos blockPos = new BlockPos(k, m, l);
            StructurePoolBasedGenerator.method_30419(dynamicRegistryManager, structurePoolFeatureConfig, PoolStructurePiece::new, chunkGenerator, structureManager, blockPos, this.children, this.random, this.towerFeature.field_25836_, this.towerFeature.surface_);
            this.setBoundingBoxFromChildren();
        }
    }
}
