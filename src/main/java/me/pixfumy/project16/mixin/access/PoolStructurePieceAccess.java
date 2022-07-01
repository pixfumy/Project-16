package me.pixfumy.project16.mixin.access;

import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.pool.StructurePoolElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PoolStructurePiece.class)
public interface PoolStructurePieceAccess {
    @Accessor
    StructurePoolElement getPoolElement();
}
