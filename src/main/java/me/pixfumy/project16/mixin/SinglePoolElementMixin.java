package me.pixfumy.project16.mixin;

import com.mojang.datafixers.util.Either;
import me.pixfumy.project16.mixin.access.SinglePoolElementAccess;
import net.minecraft.structure.Structure;
import net.minecraft.structure.pool.SinglePoolElement;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SinglePoolElement.class)
public class SinglePoolElementMixin{
    @Shadow @Final protected Either<Identifier, Structure> field_24015;

    @Override
    public boolean equals(Object other){
        if(other instanceof SinglePoolElement){
            Either<Identifier, Structure> field_24015_2 = ((SinglePoolElementAccess) other).getField_24015();
            if(this.field_24015.left().isPresent()&& field_24015_2.left().isPresent()){
                return this.field_24015.left().get().equals(field_24015_2.left().get());
            }
        }
        return false;
    }
}
