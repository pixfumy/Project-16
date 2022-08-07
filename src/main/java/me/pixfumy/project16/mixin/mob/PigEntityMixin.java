package me.pixfumy.project16.mixin.mob;

import me.pixfumy.project16.Project16;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PigEntity.class)
public class PigEntityMixin  {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void giveCrown(EntityType entityType, World world, CallbackInfo ci) {
        if (((PigEntity)(Object)this).world.random.nextFloat() < 0.005f) {
            ((PigEntity) (Object) this).equipStack(EquipmentSlot.HEAD, new ItemStack(Project16.TECHNOBLADE_CROWN));
        }
    }
}
