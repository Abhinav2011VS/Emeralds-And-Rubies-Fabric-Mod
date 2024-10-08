package net.abhinav.ear.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.abhinav.ear.block.ModBlocks;
import net.abhinav.ear.item.ModItems;
import net.fabricmc.fabric.api.tag.client.v1.ClientTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void offerEmeraldUpgradeRecipe(RecipeExporter exporter, Item input, RecipeCategory category, Item result) {
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(new ItemConvertible[]{ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE}), Ingredient.ofItems(new ItemConvertible[]{input}), Ingredient.ofItems(new ItemConvertible[]{Items.EMERALD}), category, result).criterion("has_emerald", conditionsFromItem(Items.EMERALD)).offerTo(exporter, getItemPath(result) + "_smithing");
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE,
                ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE);
        List<ItemConvertible> EMERALD_MODDED_SMELTABLES = List.of(ModBlocks.NETHER_EMERALD_ORE,
                ModBlocks.END_STONE_EMERALD_ORE);

        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 150, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 100, "ruby");
        offerSmelting(exporter, EMERALD_MODDED_SMELTABLES, RecipeCategory.MISC, Items.EMERALD, 0.30f, 170, "emerald");
        offerBlasting(exporter, EMERALD_MODDED_SMELTABLES, RecipeCategory.MISC, Items.EMERALD, 0.45f, 120, "emerald");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_RUBY_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_RUBY)
                .criterion(hasItem(ModItems.RAW_RUBY), conditionsFromItem(ModItems.RAW_RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern("RRR")
                .pattern("RGR")
                .pattern("RRR")
                .input('G', ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE)
                .input('R', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY, 9)
                .input(ModBlocks.RAW_RUBY_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_RUBY_BLOCK), conditionsFromItem(ModBlocks.RAW_RUBY_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY, 9)
                .input(ModBlocks.RUBY_BLOCK)
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter);

        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_SWORD, RecipeCategory.COMBAT, ModItems.EMERALD_SWORD);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_PICKAXE, RecipeCategory.TOOLS, ModItems.EMERALD_PICKAXE);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_AXE, RecipeCategory.TOOLS, ModItems.EMERALD_AXE);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_SHOVEL, RecipeCategory.TOOLS, ModItems.EMERALD_SHOVEL);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_HOE, RecipeCategory.TOOLS, ModItems.EMERALD_HOE);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_SWORD, RecipeCategory.TOOLS, ModItems.EMERALD_PAXEL);
        offerEmeraldUpgradeRecipe(exporter, ModItems.DIAMOND_HAMMER, RecipeCategory.COMBAT, ModItems.EMERALD_HAMMER_HEAD);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_HELMET, RecipeCategory.COMBAT, ModItems.EMERALD_HELMET);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_CHESTPLATE, RecipeCategory.COMBAT, ModItems.EMERALD_CHESTPLATE);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_LEGGINGS, RecipeCategory.COMBAT, ModItems.EMERALD_LEGGINGS);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_BOOTS, RecipeCategory.COMBAT, ModItems.EMERALD_BOOTS);

        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_HAMMER, RecipeCategory.COMBAT, ModItems.NETHERITE_HAMMER);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_AXE)
                .pattern("RR ")
                .pattern("RS ")
                .pattern(" S ")
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_HOE)
                .pattern("RR ")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE)
                .pattern("RRR")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL)
                .pattern(" R ")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PAXEL)
                .pattern("RRR")
                .pattern("RS ")
                .pattern(" S ")
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" S ")
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_HAMMER)
                .pattern("RAR")
                .pattern("RSR")
                .pattern(" S ")
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .input('A', Items.AMETHYST_SHARD)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_HELMET)
                .pattern("RRR")
                .pattern("R R")
                .pattern("   ")
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE)
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS)
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS)
                .pattern("R R")
                .pattern("R R")
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.EMERALD_HAMMER_HOLDER)
                .pattern("E")
                .pattern("H")
                .input('E', ModItems.CITRINE_SHARD)
                .input('H', Items.STICK)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.EMERALD_HAMMER)
                .pattern("G")
                .pattern("Z")
                .input('G', ModItems.EMERALD_HAMMER_HEAD)
                .input('Z', ModItems.EMERALD_HAMMER_HOLDER)
                .criterion(hasItem(ModItems.EMERALD_HAMMER_HEAD), conditionsFromItem(ModItems.EMERALD_HAMMER_HEAD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STONE_HAMMER)
                .pattern("WWW")
                .pattern("WSW")
                .pattern(" S ")
                .input('W', Items.COBBLESTONE)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.IRON_HAMMER)
                .pattern("WWW")
                .pattern("WSW")
                .pattern(" S ")
                .input('W', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GOLDEN_HAMMER)
                .pattern("WWW")
                .pattern("WSW")
                .pattern(" S ")
                .input('W', Items.GOLD_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.DIAMOND_HAMMER)
                .pattern("WWW")
                .pattern("WSW")
                .pattern(" S ")
                .input('W', Items.DIAMOND)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);

    }
}