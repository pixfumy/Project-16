package me.pixfumy.project16.mixin.mob;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;

@Mixin(WitherSkeletonEntity.class)
public abstract class WitherSkeletonEntityMixin extends MobEntity {
    protected WitherSkeletonEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
    Fixes a bug in the vanilla code where wither skeletons equip a stone sword no matter what their
     hand item is in their nbt file.
     **/
    @Inject(method = "initEquipment", at = @At("HEAD"), cancellable = true)
    private void equipOtherItem(CallbackInfo ci) {
        Iterator<ItemStack> iterator = this.getItemsHand().iterator();
        while (iterator.hasNext()) {
            ItemStack itemStack = iterator.next();
            if (itemStack.getItem() != Blocks.AIR.asItem()) {
                this.equipStack(EquipmentSlot.MAINHAND, itemStack);
                ci.cancel();
            }
        }
    }
}
