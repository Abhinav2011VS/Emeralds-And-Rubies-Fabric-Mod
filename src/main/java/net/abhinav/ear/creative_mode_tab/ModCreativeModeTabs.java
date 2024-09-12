package net.abhinav.ear.creative_mode_tab;

import net.abhinav.ear.EmeraldsAndRubies;
import net.abhinav.ear.block.ModBlocks;
import net.abhinav.ear.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeModeTabs {
    public static final ItemGroup EMERALDS_AND_RUBIES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EmeraldsAndRubies.MOD_ID, "emeralds_and_rubies"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY))
                    .displayName(Text.translatable("itemgroup.ear.emeralds_and_rubies"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.CITRINE_SHARD);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_PAXEL);
                        entries.add(ModItems.RUBY_HAMMER);
                        entries.add(ModItems.RUBY_BOW);
                        entries.add(ModItems.EMERALD_AXE);
                        entries.add(ModItems.EMERALD_HOE);
                        entries.add(ModItems.EMERALD_PICKAXE);
                        entries.add(ModItems.EMERALD_SHOVEL);
                        entries.add(ModItems.EMERALD_SWORD);
                        entries.add(ModItems.EMERALD_PAXEL);
                        entries.add(ModItems.EMERALD_HAMMER_HEAD);
                        entries.add(ModItems.EMERALD_HAMMER_HOLDER);
                        entries.add(ModItems.EMERALD_HAMMER);
                        entries.add(ModItems.EMERALD_BOW);
                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);
                        entries.add(ModItems.EMERALD_HELMET);
                        entries.add(ModItems.EMERALD_CHESTPLATE);
                        entries.add(ModItems.EMERALD_LEGGINGS);
                        entries.add(ModItems.EMERALD_BOOTS);
                        entries.add(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.EMERALD_APPLE);
                        entries.add(ModItems.ENCHANTED_EMERALD_APPLE);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_EMERALD_ORE);
                        entries.add(ModBlocks.END_STONE_EMERALD_ORE);
                    }).build());

    public static void registerModCreativeModeTabs() {
        EmeraldsAndRubies.LOGGER.info("Registering Creative Mode Tab for EAR");
    }
}
