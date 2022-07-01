package net.dylan.penguins.item;

import net.dylan.penguins.Penguins;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup PENGUIN_STUFFS = FabricItemGroupBuilder.build(
            new Identifier(Penguins.MOD_ID, "penguin_stuffs"), () -> new ItemStack(ModItems.PENGUIN_FOOT));
}
