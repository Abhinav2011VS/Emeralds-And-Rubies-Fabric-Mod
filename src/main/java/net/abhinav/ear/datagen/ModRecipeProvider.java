package net.abhinav.ear.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.abhinav.ear.block.ModBlocks;
import net.abhinav.ear.item.ModItems;
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
        offerSmelting(exporter, EMERALD_MODDED_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.30f, 170, "emerald");
        offerBlasting(exporter, EMERALD_MODDED_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.45f, 120, "emerald");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_RUBY_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_RUBY)
                .criterion(hasItem(ModItems.RAW_RUBY), conditionsFromItem(ModItems.RAW_RUBY))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY, 9)
                .input(ModBlocks.RAW_RUBY_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_RUBY_BLOCK), conditionsFromItem(ModBlocks.RAW_RUBY_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK)
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

        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_SWORD, RecipeCategory.MISC, ModItems.EMERALD_SWORD);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_PICKAXE, RecipeCategory.MISC, ModItems.EMERALD_PICKAXE);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_AXE, RecipeCategory.MISC, ModItems.EMERALD_AXE);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_SHOVEL, RecipeCategory.MISC, ModItems.EMERALD_SHOVEL);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_HOE, RecipeCategory.MISC, ModItems.EMERALD_HOE);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_HELMET, RecipeCategory.MISC, ModItems.EMERALD_HELMET);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_CHESTPLATE, RecipeCategory.MISC, ModItems.EMERALD_CHESTPLATE);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_LEGGINGS, RecipeCategory.MISC, ModItems.EMERALD_LEGGINGS);
        offerEmeraldUpgradeRecipe(exporter, Items.DIAMOND_BOOTS, RecipeCategory.MISC, ModItems.EMERALD_BOOTS);

    }
}