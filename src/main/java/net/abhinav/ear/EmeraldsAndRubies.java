package net.abhinav.ear;

import net.abhinav.ear.block.ModBlocks;
import net.abhinav.ear.creative_mode_tab.ModCreativeModeTabs;
import net.abhinav.ear.item.ModItems;
import net.abhinav.ear.util.HammerUsageEvent;
import net.abhinav.ear.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmeraldsAndRubies implements ModInitializer {
    public static final String MOD_ID = "ear";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Register items, blocks, creative tabs, and world generation
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModCreativeModeTabs.registerModCreativeModeTabs();
        ModWorldGeneration.generateModWorldGeneration();

        // Register event handler
        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
    }
}
