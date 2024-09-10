package net.abhinav.ear.item;

import net.abhinav.ear.EmeraldsAndRubies;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class ModBlockTags {
    public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = of("incorrect_for_ruby_tool");
    public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = of("incorrect_for_emerald_tool");
    private ModBlockTags() {
    }

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(EmeraldsAndRubies.MOD_ID));
    }
}
