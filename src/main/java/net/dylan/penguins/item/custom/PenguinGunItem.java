package net.dylan.penguins.item.custom;

import net.dylan.penguins.block.ModBlocks;
import net.dylan.penguins.entity.ModEntities;
import net.dylan.penguins.entity.custom.PenguinEntity;
import net.dylan.penguins.item.ModItemGroup;
import net.dylan.penguins.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PenguinGunItem extends Item {
    public PenguinGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = null;
        boolean bl2;
        boolean bl = user.getAbilities().creativeMode;
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(Item.fromBlock(ModBlocks.COMPRESSED_PENGUIN));
        }
        bl2 = bl && itemStack.isOf(Item.fromBlock(ModBlocks.COMPRESSED_PENGUIN));
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if(!world.isClient() && hand == hand.MAIN_HAND) {
            PenguinEntity penguin = new PenguinEntity(ModEntities.PENGUIN, world);
            penguin.setPosition(user.getPos());
            penguin.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 3f, 1.0f);
            world.spawnEntity(penguin);
        }
        if (!bl2 && !user.getAbilities().creativeMode) {
            itemStack.decrement(1);
            if (itemStack.isEmpty()) {
                user.getInventory().removeOne(itemStack);
            }
        }

        return super.use(world, user, hand);
    }
}
