package me.pixfumy.project16;

import me.pixfumy.project16.features.TowerFeature;
import me.pixfumy.project16.features.TowerPiece;
import net.fabricmc.api.ModInitializer;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Project16 implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("Project 16");
	public static final StructureFeature<StructurePoolFeatureConfig> FEATURE = StructureFeature.register(
			"project16:tower",
			new TowerFeature(StructurePoolFeatureConfig.CODEC),
			GenerationStep.Feature.SURFACE_STRUCTURES
	);

	public static final StructurePieceType TOWER_PIECE = StructurePieceType.register(
			TowerPiece::new,
			"project16:tower_piece"
	);
	public static final Identifier TOWER_POOL = new Identifier("project16:tower_pool");

	public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ? extends StructureFeature<StructurePoolFeatureConfig>> FEATURE_CONFIGURED
			= FEATURE.configure(new StructurePoolFeatureConfig(TOWER_POOL, 7));
	@Override
	public void onInitialize() {
		Registry.BIOME.forEach(biome -> {
			biome.addStructureFeature(FEATURE_CONFIGURED);
		});
	}
}
