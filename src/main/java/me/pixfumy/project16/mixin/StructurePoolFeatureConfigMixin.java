package me.pixfumy.project16.mixin;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.pixfumy.project16.mixinterface.IStructurePoolFeatureConfig;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mixin(StructurePoolFeatureConfig.class)
public class StructurePoolFeatureConfigMixin implements IStructurePoolFeatureConfig {
    @Mutable
    @Shadow @Final public static Codec<StructurePoolFeatureConfig> CODEC;
    @Shadow @Final private Supplier<StructurePool> startPool;
    @Shadow @Final private int size;
    List<Pair<List<StructurePoolElement>, Integer>> limitedStructurePoolElements = new ArrayList<com.mojang.datafixers.util.Pair<List<StructurePoolElement>, Integer>>();


    @Inject(method="<clinit>",at=@At("TAIL"))
    private static void setCodec(CallbackInfo ci){
        CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(
                    (StructurePool.REGISTRY_CODEC.fieldOf("start_pool"))
                            .forGetter(StructurePoolFeatureConfig::getStartPool),
                    (Codec.intRange(0, 7).fieldOf("size"))
                            .forGetter(StructurePoolFeatureConfig::getSize),
                    (Codec.list(Codec.pair(Codec.list(StructurePoolElement.CODEC).fieldOf("list").codec(),Codec.INT.fieldOf("count").codec()))).fieldOf("limitedStructurePoolElements")
                            .forGetter(structurePoolFeatureConfig -> ((IStructurePoolFeatureConfig)structurePoolFeatureConfig).getLimitedStructurePoolElements())
                    ).apply(instance, StructurePoolFeatureConfigMixin::create);
        });
    }

    private static StructurePoolFeatureConfig create(Supplier<StructurePool> startPool, int size,List<Pair<List<StructurePoolElement>, Integer>> limitedStructurePoolElements){
        return ((IStructurePoolFeatureConfig)new StructurePoolFeatureConfig(startPool,size)).setLimitedStructurePoolElements(limitedStructurePoolElements);
    }

    @Override
    public List<Pair<List<StructurePoolElement>, Integer>> getLimitedStructurePoolElements() {
        return limitedStructurePoolElements;
    }

    @Override
    public StructurePoolFeatureConfig setLimitedStructurePoolElements(List<Pair<List<StructurePoolElement>, Integer>> list) {
        this.limitedStructurePoolElements = list;
        return (StructurePoolFeatureConfig) (Object)this;
    }
}
