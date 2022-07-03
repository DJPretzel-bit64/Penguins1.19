package net.dylan.penguins;

import net.dylan.penguins.block.ModBlocks;
import net.dylan.penguins.entity.ModEntities;
import net.dylan.penguins.entity.custom.PenguinEntity;
import net.dylan.penguins.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Penguins implements ModInitializer {
	public static final String MOD_ID = "penguins";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerAttributes();
	}
}
