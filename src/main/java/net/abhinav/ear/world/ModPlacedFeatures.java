package net.abhinav.ear.world;

import net.abhinav.ear.EmeraldsAndRubies;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ModPlacedFeatures {

    // RegistryKeys for placed features, which define where and how features generate in the world
    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_RUBY_ORE_PLACED_KEY = registerKey("nether_ruby_ore_placed");
    public static final RegistryKey<PlacedFeature> END_RUBY_ORE_PLACED_KEY = registerKey("end_ruby_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_EMERALD_ORE_PLACED_KEY = registerKey("nether_emerald_ore_placed");
    public static final RegistryKey<PlacedFeature> END_EMERALD_ORE_PLACED_KEY = registerKey("end_emerald_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        // Look up the ConfiguredFeatures registered earlier in ModConfiguredFeatures
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // Ruby ore placements in the Overworld, Nether, and End dimensions
        register(context, RUBY_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, // Set the count of Ruby ore veins per chunk to 8
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))); // Ruby ores generate between Y levels -80 and 80

        register(context, NETHER_RUBY_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, // Set the count of Ruby ore veins per chunk to 8
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120)))); // Ruby ores generate between Y levels 0 and 120 in the Nether

        register(context, END_RUBY_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_RUBY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, // Set the count of Ruby ore veins per chunk to 8
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(80)))); // Ruby ores generate between Y levels 0 and 80 in the End

        register(context, NETHER_EMERALD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_EMERALD_ORE_KEY),
                ModOrePlacement.modifiersWithCount(18, // Set the count of Emerald ore veins per chunk to 18
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120)))); // Emerald ores generate between Y levels 0 and 120 in the Nether

        register(context, END_EMERALD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_EMERALD_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12, // Set the count of Emerald ore veins per chunk to 12
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(80)))); // Emerald ores generate between Y levels 0 and 80 in the End
    }

    // Helper method to register a RegistryKey<PlacedFeature> for a feature
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(EmeraldsAndRubies.MOD_ID, name));
    }

    // Registers a placed feature with a list of placement modifiers
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    // Overloaded method that accepts variable arguments for placement modifiers
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
