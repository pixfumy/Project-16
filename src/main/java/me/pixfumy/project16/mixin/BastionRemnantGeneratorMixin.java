package me.pixfumy.project16.mixin;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.BastionRemnantGenerator;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BastionRemnantGenerator.class)
public class BastionRemnantGeneratorMixin {
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/structure/pool/StructurePools;register(Lnet/minecraft/structure/pool/StructurePool;)Lnet/minecraft/structure/pool/StructurePool;"))
    private static StructurePool addNewBastions(StructurePool templatePool) {
        StructurePools.register(new StructurePool(new Identifier("project16:bastion/folly/towers_upper"), new Identifier("empty"), ImmutableList.of(Pair.of(StructurePoolElement.method_30435("project16:bastion/folly/towers_upper/folly_towers_upper", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1)), StructurePool.Projection.RIGID));
        return StructurePools.register(new StructurePool(new Identifier("bastion/starts"), new Identifier("empty"), ImmutableList.of(Pair.of(StructurePoolElement.method_30435("bastion/units/air_base", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1), Pair.of(StructurePoolElement.method_30435("bastion/hoglin_stable/air_base", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1), Pair.of(StructurePoolElement.method_30435("bastion/treasure/big_air_full", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1), Pair.of(StructurePoolElement.method_30435("bastion/bridge/starting_pieces/entrance_base", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1), Pair.of(StructurePoolElement.method_30435("project16:bastion/folly/start/folly_start", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1)), StructurePool.Projection.RIGID));
    }
}
