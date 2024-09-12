package net.abhinav.ear.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    public static final FoodComponent EMERALD_APPLE = new FoodComponent.Builder().nutrition(6).saturationModifier(6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 4), 3)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100, 2), 8)
            .alwaysEdible()
            .build();

    public static final FoodComponent ENCHANTED_EMERALD_APPLE = new FoodComponent.Builder().nutrition(10).saturationModifier(10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 400, 13), 6)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 5), 5)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 400, 7), 10)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 400, 9), 9)
            .alwaysEdible()
            .build();
}
