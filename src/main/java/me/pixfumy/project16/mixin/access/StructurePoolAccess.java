package me.pixfumy.project16.mixin.access;

import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(StructurePool.class)
public interface StructurePoolAccess {
    @Accessor
    List<Pair<StructurePoolElement, Integer>> getElementCounts();
    @Accessor
    List<StructurePoolElement> getElements();
}
