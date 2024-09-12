package net.abhinav.ear;

import net.abhinav.ear.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;

public class EmeraldsAndRubiesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register model predicates
        ModModelPredicates.registerModelPredicates();
    }
}
