package me.pixfumy.project16.mixin;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import me.pixfumy.project16.mixin.access.PoolStructurePieceAccess;
import me.pixfumy.project16.mixinterface.IStructurePoolFeatureConfig;
import me.pixfumy.project16.mixinterface.IStructurePoolGenerator;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Mixin(StructurePoolBasedGenerator.StructurePoolGenerator.class)
public class StructurePoolGeneratorMixin implements IStructurePoolGenerator {
    @Shadow @Final private List<? super PoolStructurePiece> children;
    StructurePoolFeatureConfig structurePoolFeatureConfig;
    @Redirect(method = "generatePiece",at=@At(value="INVOKE",target = "Ljava/util/List;addAll(Ljava/util/Collection;)Z"))
    private boolean removeUsedLimitedStructurePoolElements(List<StructurePoolElement> instance, Collection<StructurePoolElement> poolSample){
        //inefficient algorithm but performance isn't necessary here
        List<Pair<List<StructurePoolElement>, Integer>> list = ((IStructurePoolFeatureConfig) structurePoolFeatureConfig).getLimitedStructurePoolElements();
        Set<StructurePoolElement> toRemove = new ObjectArraySet<>();
        for(Pair<List<StructurePoolElement>, Integer> pair : list){
            int i = 0;
            for(StructurePoolElement element : pair.getFirst()){
                i+= this.children.stream().filter(element1->((PoolStructurePieceAccess)element1).getPoolElement().equals(element)).count();
            }
            if(i>= pair.getSecond()){
                toRemove.addAll(pair.getFirst());
            }
        }
        instance.addAll(poolSample);
        instance.removeAll(toRemove);
        return true;
    }

    @Override
    public void setStructurePoolFeatureConfig(StructurePoolFeatureConfig config) {
        this.structurePoolFeatureConfig = config;
    }
}
