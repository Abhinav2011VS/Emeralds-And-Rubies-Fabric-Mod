package net.abhinav.ear.item;

import net.abhinav.ear.EmeraldsAndRubies;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

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

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EmeraldsAndRubies.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EmeraldsAndRubies.LOGGER.info("Registering Mod Items for EAR");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RUBY);
            entries.add(RAW_RUBY);
        });
    }
}
