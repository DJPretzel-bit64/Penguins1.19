package net.dylan.penguins.item.custom;

import net.dylan.penguins.block.ModBlocks;
import net.dylan.penguins.entity.ModEntities;
import net.dylan.penguins.entity.custom.PenguinEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PenguinGunItem extends Item {
    public PenguinGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getEquippedStack(EquipmentSlot.OFFHAND);
        boolean bl2;
        boolean bl = user.getAbilities().creativeMode;
        bl2 = bl && itemStack.isOf(ModBlocks.COMPRESSED_PENGUIN_ITEM);
        user.getItemCooldownManager().set(this, 10);
        if(!world.isClient() && (hand == hand.MAIN_HAND && itemStack.isOf(ModBlocks.COMPRESSED_PENGUIN_ITEM) || user.getAbilities().creativeMode)) {
            PenguinEntity penguin = new PenguinEntity(ModEntities.PENGUIN, world);
            penguin.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 60, 1));
            penguin.setPosition(new Vec3d(user.getPos().x, user.getPos().y + 1, user.getPos().z));
            penguin.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 3f, 1.0f);
            world.spawnEntity(penguin);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        }
        if(!bl2 && !user.getAbilities().creativeMode) {
            itemStack.decrement(1);
            if(itemStack.isEmpty()) {
                user.getInventory().removeOne(itemStack);
            }
        }

        return super.use(world, user, hand);
    }
}
