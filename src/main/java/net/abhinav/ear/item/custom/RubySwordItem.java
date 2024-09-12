package net.abhinav.ear.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class RubySwordItem extends SwordItem {

    public RubySwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        super.postHit(stack, target, attacker);

        // Set the target on fire for 5 seconds (100 ticks)
        target.setOnFireFor(200);

        return true;
    }
}

