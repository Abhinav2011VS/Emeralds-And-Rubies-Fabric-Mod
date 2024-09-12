package net.abhinav.ear.world;

import net.abhinav.ear.EmeraldsAndRubies;
import net.abhinav.ear.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_RUBY_ORE_KEY = registerKey("end_ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_EMERALD_ORE_KEY = registerKey("nether_emerald_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_EMERALD_ORE_KEY = registerKey("end_emerald_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        // Ruby ore targets
        List<OreFeatureConfig.Target> overworldRubyOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RUBY_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherRubyOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_RUBY_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endRubyOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_STONE_RUBY_ORE.getDefaultState()));

        // Emerald ore targets
        List<OreFeatureConfig.Target> netherEmeraldOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_EMERALD_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endEmeraldOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_STONE_EMERALD_ORE.getDefaultState()));

        // Register Ruby ore configurations
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRubyOres, 12));
        register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherRubyOres, 9));
        register(context, END_RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(endRubyOres, 8));

        // Register Emerald ore configurations (ensure these use Emerald targets, not Ruby)
        register(context, NETHER_EMERALD_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherEmeraldOres, 17));
        register(context, END_EMERALD_ORE_KEY, Feature.ORE, new OreFeatureConfig(endEmeraldOres, 18));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(EmeraldsAndRubies.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
