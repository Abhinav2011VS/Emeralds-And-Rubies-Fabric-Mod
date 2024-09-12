package net.abhinav.ear.item;

import net.abhinav.ear.EmeraldsAndRubies;
import net.abhinav.ear.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
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

    public static final Item CITRINE_SHARD = registerItem("citrine_shard", new Item(new Item.Settings())); //143.24


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
            (Item)(new RubySwordItem(ModToolMaterials.RUBY, (new Item.Settings()).attributeModifiers
                    (SwordItem.createAttributeModifiers
                            (ModToolMaterials.RUBY, 5, -2.4F)))));

    public static final Item RUBY_HOE = registerItem((String)"ruby_hoe",
            (Item)(new HoeItem(ModToolMaterials.RUBY, (new Item.Settings()).attributeModifiers
                    (HoeItem.createAttributeModifiers
                            (ModToolMaterials.RUBY, 0.0F, 0.0F)))));

    public static final Item RUBY_PAXEL = registerItem("ruby_paxel",
            new PaxelItem(ModToolMaterials.RUBY,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 4, -2.5f))));
    public static final Item RUBY_HAMMER = registerItem("ruby_hammer",
            new HammerItem(ModToolMaterials.RUBY,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 8, -3.5f))));

    public static final Item RUBY_BOW =registerItem("ruby_bow",
            new BowItem(new Item.Settings().maxDamage(400)));

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
                            (ModToolMaterials.EMERALD, 11, -2.4F)))));

    public static final Item EMERALD_HOE = registerItem((String)"emerald_hoe",
            (Item)(new HoeItem(ModToolMaterials.EMERALD, (new Item.Settings()).attributeModifiers
                    (HoeItem.createAttributeModifiers
                            (ModToolMaterials.EMERALD, 1.0F, 0.0F)))));

    public static final Item EMERALD_PAXEL = registerItem("emerald_paxel",
            new PaxelItem(ModToolMaterials.EMERALD,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.EMERALD, 4, -2.5f))));

    public static final Item EMERALD_HAMMER_HEAD = registerItem("emerald_hammer_head", new Item(new Item.Settings()));
    public static final Item EMERALD_HAMMER_HOLDER = registerItem("emerald_hammer_holder", new Item(new Item.Settings()));
    public static final Item EMERALD_HAMMER = registerItem("emerald_hammer",
            new HammerItem(ModToolMaterials.EMERALD,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.EMERALD, 25, -3.5f))));

    public static final Item EMERALD_BOW =registerItem("emerald_bow",
            new BowItem(new Item.Settings().maxDamage(900)));


    public static final Item RUBY_HELMET = registerItem((String)"ruby_helmet",
            (Item)(new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(33)))));

    public static final Item RUBY_CHESTPLATE = registerItem((String)"ruby_chestplate",
            (Item)(new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(33)))));

    public static final Item RUBY_LEGGINGS = registerItem((String)"ruby_leggings",
            (Item)(new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(33)))));

    public static final Item RUBY_BOOTS = registerItem((String)"ruby_boots",
            (Item)(new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(33)))));

    public static final Item EMERALD_HELMET = registerItem((String)"emerald_helmet",
            (Item)(new EmeraldArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(33)))));

    public static final Item EMERALD_CHESTPLATE = registerItem((String)"emerald_chestplate",
            (Item)(new EmeraldArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(33)))));

    public static final Item EMERALD_LEGGINGS = registerItem((String)"emerald_leggings",
            (Item)(new EmeraldArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(33)))));

    public static final Item EMERALD_BOOTS = registerItem((String)"emerald_boots",
            (Item)(new EmeraldArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS,
                    (new Item.Settings()).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(33)))));

    public static final Item EMERALD_UPGRADE_SMITHING_TEMPLATE = registerItem((String)"emerald_upgrade_smithing_template", (Item)ModSmithingTemplateItem.createEmeraldUpgrade());

    public static final Item EMERALD_APPLE = registerItem("emerald_apple",
            new Item(new Item.Settings().food(ModFoodComponents.EMERALD_APPLE).rarity(Rarity.RARE)) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.ear.emerald_apple.tooltip"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item ENCHANTED_EMERALD_APPLE = registerItem("enchanted_emerald_apple",
            new Item(new Item.Settings().food(ModFoodComponents.ENCHANTED_EMERALD_APPLE).fireproof().rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.ear.enchanted_emerald_apple.tooltip"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer",
            new HammerItem(ToolMaterials.WOOD,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.WOOD, 4, -3))));

    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new HammerItem(ToolMaterials.STONE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.STONE, 5, -3))));

    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(ToolMaterials.IRON,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 6, -2))));

    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer",
            new HammerItem(ToolMaterials.GOLD,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.GOLD, 4, -1))));

    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(ToolMaterials.DIAMOND,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 7, -2))));

    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(ToolMaterials.NETHERITE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 8, -1))));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EmeraldsAndRubies.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EmeraldsAndRubies.LOGGER.info("Registering Items for EAR");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RUBY);
            entries.add(RAW_RUBY);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(WOODEN_HAMMER);
            entries.add(STONE_HAMMER);
            entries.add(IRON_HAMMER);
            entries.add(GOLDEN_HAMMER);
            entries.add(DIAMOND_HAMMER);
            entries.add(NETHERITE_HAMMER);
        });
    }
}
