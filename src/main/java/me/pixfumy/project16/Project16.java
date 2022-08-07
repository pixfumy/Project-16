package me.pixfumy.project16;

import me.pixfumy.project16.item.CrownMaterial;
import me.pixfumy.project16.structure.Structures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Project16 implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("Project 16");

	public static String modid = "project16";
	public static final ItemGroup PROJECT16_GROUP = FabricItemGroupBuilder.create(
			new Identifier(modid, "items")).icon(() -> new ItemStack(Items.GOLDEN_CARROT)).build();
	public static final ArmorItem TECHNOBLADE_CROWN = new ArmorItem(new CrownMaterial(), EquipmentSlot.HEAD, new Item.Settings().group(PROJECT16_GROUP));


	@Override
	public void onInitialize() {
		StructurePoolFeatureConfig.CODEC.listOf();
		FabricStructureBuilder.create(new Identifier(modid, "tower"), Structures.TOWER)
				.step(GenerationStep.Feature.SURFACE_STRUCTURES)
				.defaultConfig(32, 8, 86421)
				.register();
		FabricStructureBuilder.create(new Identifier(modid, "pride"), Structures.PRIDE)
				.step(GenerationStep.Feature.SURFACE_STRUCTURES)
				.defaultConfig(16, 8, 561349)
				.register();
		FabricStructureBuilder.create(new Identifier(modid, "nether_ship"), Structures.NETHER_SHIP)
				.step(GenerationStep.Feature.UNDERGROUND_STRUCTURES)
				.defaultConfig(16, 8, 34535636)
				.register();
		Registry.register(Registry.ITEM, new Identifier(modid, "technoblade_crown"), TECHNOBLADE_CROWN);
	}
}
