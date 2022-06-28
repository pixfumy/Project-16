package me.pixfumy.project16;

import me.pixfumy.structure.Structures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Project16 implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("Project 16");

	public static String modid = "project16";


	@Override
	public void onInitialize() {
		FabricStructureBuilder.create(new Identifier(modid, "tower"), Structures.TOWER)
				.step(GenerationStep.Feature.SURFACE_STRUCTURES)
				.defaultConfig(1, 0, 0)
				.adjustsSurface()
				.register();
	}
}
