package net.abhinav.ear.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ENCHANTED_EMERALD_APPLE = new FoodComponent.Builder().nutrition(10).saturationModifier(10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 400, 1543), 6)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 2932), 5)
            .build();
}
