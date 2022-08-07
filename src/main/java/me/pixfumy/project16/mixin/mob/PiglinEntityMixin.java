package me.pixfumy.project16.mixin.mob;

import me.pixfumy.project16.Project16;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PiglinEntity.class)
public class PiglinEntityMixin {
    @Inject(method = "initEquipment", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/PiglinEntity;equipAtChance(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V", shift = At.Shift.AFTER))
    private void giveCrown(CallbackInfo ci) {
        if (((PiglinEntity)(Object)this).world.random.nextFloat() < 0.005f) {
            ((PiglinEntity) (Object) this).equipStack(EquipmentSlot.HEAD, new ItemStack(Project16.TECHNOBLADE_CROWN));
        }
    }
}
