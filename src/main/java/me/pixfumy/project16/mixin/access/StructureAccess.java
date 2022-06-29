package me.pixfumy.project16.mixin.access;

import net.minecraft.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(Structure.class)
public interface StructureAccess {
    @Accessor
    List<Structure.PalettedBlockInfoList> getBlockInfoLists();
}
