package net.abhinav.ear.item;

import net.abhinav.ear.EmeraldsAndRubies;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));

    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));


    public static final Item RUBY_PICKAXE = registerItem((String)"ruby_pickaxe",
            (Item)(new PickaxeItem(ModToolMaterials.RUBY, (new Item.Settings()).attributeModifiers
                    (PickaxeItem.createAttributeModifiers
                            (ModToolMaterials.RUBY, 2.0F, 2.0F)))));

    public static final Item RUBY_AXE = registerItem((String)"ruby_axe",
            (Item)(new AxeItem(ModToolMaterials.RUBY, (new Item.Settings()).attributeModifiers
                    (AxeItem.createAttributeModifiers
                            (ModToolMaterials.RUBY, 4.0F, 1.0F)))));

    public static final Item RUBY_SHOVEL = registerItem((String)"ruby_shovel",
            (Item)(new ShovelItem(ModToolMaterials.RUBY, (new Item.Settings()).attributeModifiers
                    (ShovelItem.createAttributeModifiers
                            (ModToolMaterials.RUBY, 0.5F, -1.0F)))));

    public static final Item RUBY_SWORD = registerItem((String)"ruby_sword",
            (Item)(new SwordItem(ModToolMaterials.RUBY, (new Item.Settings()).attributeModifiers
                    (SwordItem.createAttributeModifiers
                            (ModToolMaterials.RUBY, 5, -2.4F)))));

    public static final Item RUBY_HOE = registerItem((String)"ruby_hoe",
            (Item)(new HoeItem(ModToolMaterials.RUBY, (new Item.Settings()).attributeModifiers
                    (HoeItem.createAttributeModifiers
                            (ModToolMaterials.RUBY, 0.0F, 0.0F)))));

    public static final Item EMERALD_PICKAXE = registerItem((String)"emerald_pickaxe",
            (Item)(new PickaxeItem(ModToolMaterials.EMERALD, (new Item.Settings()).attributeModifiers
                    (PickaxeItem.createAttributeModifiers
                            (ModToolMaterials.EMERALD, 2.0F, 2.0F)))));

    public static final Item EMERALD_AXE = registerItem((String)"emerald_axe",
            (Item)(new AxeItem(ModToolMaterials.EMERALD, (new Item.Settings()).attributeModifiers
                    (AxeItem.createAttributeModifiers
                            (ModToolMaterials.EMERALD, 4.5F, 1.0F)))));

    public static final Item EMERALD_SHOVEL = registerItem((String)"emerald_shovel",
            (Item)(new ShovelItem(ModToolMaterials.EMERALD, (new Item.Settings()).attributeModifiers
                    (ShovelItem.createAttributeModifiers
                            (ModToolMaterials.EMERALD, 0.5F, -1.0F)))));

    public static final Item EMERALD_SWORD = registerItem((String)"emerald_sword",
            (Item)(new SwordItem(ModToolMaterials.EMERALD, (new Item.Settings()).attributeModifiers
                    (SwordItem.createAttributeModifiers
                            (ModToolMaterials.EMERALD, 7, -2.4F)))));

    public static final Item EMERALD_HOE = registerItem((String)"emerald_hoe",
            (Item)(new HoeItem(ModToolMaterials.EMERALD, (new Item.Settings()).attributeModifiers
                    (HoeItem.createAttributeModifiers
                            (ModToolMaterials.EMERALD, 1.0F, 0.0F)))));


    public static final Item RUBY_HELMET = registerItem((String)"ruby_helmet",
            (Item)(new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(33)))));

    public static final Item RUBY_CHESTPLATE = registerItem((String)"ruby_chestplate",
            (Item)(new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(33)))));

    public static final Item RUBY_LEGGINGS = registerItem((String)"ruby_leggings",
            (Item)(new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(33)))));

    public static final Item RUBY_BOOTS = registerItem((String)"ruby_boots",
            (Item)(new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(33)))));

    public static final Item EMERALD_HELMET = registerItem((String)"emerald_helmet",
            (Item)(new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(33)))));

    public static final Item EMERALD_CHESTPLATE = registerItem((String)"emerald_chestplate",
            (Item)(new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(33)))));

    public static final Item EMERALD_LEGGINGS = registerItem((String)"emerald_leggings",
            (Item)(new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(33)))));

    public static final Item EMERALD_BOOTS = registerItem((String)"emerald_boots",
            (Item)(new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(33)))));

    public static final Item EMERALD_UPGRADE_SMITHING_TEMPLATE = registerItem((String)"emerald_upgrade_smithing_template", (Item)ModSmithingTemplateItem.createEmeraldUpgrade());

    public static final Item ENCHANTED_EMERALD_APPLE = registerItem("enchanted_emerald_apple",
            new Item(new Item.Settings().food(ModFoodComponents.ENCHANTED_EMERALD_APPLE)) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.ear.enchanted_emerald_apple.tooltip"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EmeraldsAndRubies.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EmeraldsAndRubies.LOGGER.info("Registering Items for EAR");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RUBY);
            entries.add(RAW_RUBY);
        });
    }
}
