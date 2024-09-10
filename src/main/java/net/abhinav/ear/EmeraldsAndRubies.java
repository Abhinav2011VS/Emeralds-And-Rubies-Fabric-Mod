package net.abhinav.ear;

import net.abhinav.ear.block.ModBlocks;
import net.abhinav.ear.creative_mode_tab.ModCreativeModeTabs;
import net.abhinav.ear.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.logging.ILogger;

public class EmeraldsAndRubies implements ModInitializer {
    public static final String MOD_ID = "ear";
    public static Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModCreativeModeTabs.registerModCreativeModeTabs();

    }
}
