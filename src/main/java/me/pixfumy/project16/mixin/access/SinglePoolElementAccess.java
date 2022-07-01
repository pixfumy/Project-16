package me.pixfumy.project16.mixin.access;

import com.mojang.datafixers.util.Either;
import net.minecraft.structure.Structure;
import net.minecraft.structure.pool.SinglePoolElement;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SinglePoolElement.class)
public interface SinglePoolElementAccess {
    @Accessor
    Either<Identifier, Structure> getField_24015();
}
