package me.pixfumy.project16.mixin.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import me.pixfumy.project16.mixin.access.StructureProcessorListsAccess;
import me.pixfumy.project16.structure.BastionSpireData;
import net.minecraft.block.Blocks;
import net.minecraft.structure.BastionRemnantGenerator;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.RuleStructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.structure.processor.StructureProcessorRule;
import net.minecraft.structure.rule.AlwaysTrueRuleTest;
import net.minecraft.structure.rule.RandomBlockMatchRuleTest;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BastionRemnantGenerator.class)
public class BastionRemnantGeneratorMixin {
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/structure/pool/StructurePools;register(Lnet/minecraft/structure/pool/StructurePool;)Lnet/minecraft/structure/pool/StructurePool;"))
    private static StructurePool addNewBastions(StructurePool templatePool) {
        StructureProcessorList SPIRE_LAVA_FLOOR = StructureProcessorListsAccess.invokeRegister(
                "spire_lava_floor",
                ImmutableList.of(
                        new RuleStructureProcessor(
                                ImmutableList.of(
                                        new StructureProcessorRule(
                                                new RandomBlockMatchRuleTest(Blocks.LAVA, 0.15f), AlwaysTrueRuleTest.INSTANCE, Blocks.OBSIDIAN.getDefaultState()),
                                        new StructureProcessorRule(
                                                new RandomBlockMatchRuleTest(Blocks.LAVA, 0.001f), AlwaysTrueRuleTest.INSTANCE, Blocks.ANCIENT_DEBRIS.getDefaultState()),
                                        new StructureProcessorRule(new
                                                RandomBlockMatchRuleTest(Blocks.LAVA, 0.20f), AlwaysTrueRuleTest.INSTANCE, Blocks.CRYING_OBSIDIAN.getDefaultState())))));
        return StructurePools.register(
                new StructurePool(
                        new Identifier("bastion/starts"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.method_30435("bastion/units/air_base", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1),
                                Pair.of(StructurePoolElement.method_30435("bastion/hoglin_stable/air_base", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1),
                                Pair.of(StructurePoolElement.method_30435("bastion/treasure/big_air_full", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1),
                                Pair.of(StructurePoolElement.method_30435("bastion/bridge/starting_pieces/entrance_base", StructureProcessorLists.BASTION_GENERIC_DEGRADATION), 1),
                                Pair.of(StructurePoolElement.method_30435("project16:bastion/spire/start/start", SPIRE_LAVA_FLOOR), 1)),
                        StructurePool.Projection.RIGID));
    }

    @Inject(method = "init", at = @At("TAIL"))
    private static void loadNewBastionData(CallbackInfo ci) {
        BastionSpireData.init();
    }
}
