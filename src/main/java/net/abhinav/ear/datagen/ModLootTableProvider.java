package net.abhinav.ear.datagen;

import net.abhinav.ear.block.ModBlocks;
import net.abhinav.ear.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Generate block loot tables
        generateBlockLootTables();
    }

    private void generateBlockLootTables() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RAW_RUBY_BLOCK);

        addDrop(ModBlocks.RUBY_ORE, multipleOreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY, 2, 3));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY, 3, 7));
        addDrop(ModBlocks.NETHER_RUBY_ORE, multipleOreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_RUBY, 3, 5));
        addDrop(ModBlocks.END_STONE_RUBY_ORE, multipleOreDrops(ModBlocks.END_STONE_RUBY_ORE, ModItems.RAW_RUBY, 4, 9));
        addDrop(ModBlocks.NETHER_EMERALD_ORE, multipleOreDrops(ModBlocks.NETHER_EMERALD_ORE, Items.EMERALD, 3, 5));
        addDrop(ModBlocks.END_STONE_EMERALD_ORE, multipleOreDrops(ModBlocks.END_STONE_EMERALD_ORE, Items.EMERALD, 3, 8));
    }

    private LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                .apply(ApplyBonusLootFunction.oreDrops(getOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)))));
    }

    private RegistryWrapper<Enchantment> getOrThrow(RegistryKey<Registry<Enchantment>> key) {
        return this.registryLookup.getWrapperOrThrow(key);
    }
}
