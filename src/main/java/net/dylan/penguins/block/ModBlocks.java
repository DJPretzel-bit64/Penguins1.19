package net.dylan.penguins.block;

import net.dylan.penguins.Penguins;
import net.dylan.penguins.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block COMPRESSED_PENGUIN = registerBlock("compressed_penguin",
            new Block(FabricBlockSettings.of(Material.SCULK).requiresTool().hardness(2f)), ModItemGroup.PENGUIN_STUFFS);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Penguins.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Penguins.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        Penguins.LOGGER.debug("Registering ModBlocks for " + Penguins.MOD_ID);
    }
}
