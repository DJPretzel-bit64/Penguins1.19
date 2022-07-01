package net.dylan.penguins.item;

import net.dylan.penguins.Penguins;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item PENGUIN_FOOT = registerItem("penguin_foot",
            new Item(new FabricItemSettings().group(ModItemGroup.PENGUIN_STUFFS)));

    public static final Item PENGUIN_BODY = registerItem("penguin_body",
            new Item(new FabricItemSettings().group(ModItemGroup.PENGUIN_STUFFS)));

    public static final Item PENGUIN_HEAD = registerItem("penguin_head",
            new Item(new FabricItemSettings().group(ModItemGroup.PENGUIN_STUFFS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Penguins.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Penguins.LOGGER.debug("Registering Mod Items for " + Penguins.MOD_ID);
    }
}
