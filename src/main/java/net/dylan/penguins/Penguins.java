package net.dylan.penguins;

import net.dylan.penguins.block.ModBlocks;
import net.dylan.penguins.entity.ModEntities;
import net.dylan.penguins.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.example.GeckoLibMod;

public class Penguins implements ModInitializer {
	public static final String MOD_ID = "penguins";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		GeckoLibMod.DISABLE_IN_DEV = true;
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerAttributes();
	}
}
