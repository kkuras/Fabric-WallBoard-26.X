package net.kkura.wallboard.block;

import net.kkura.wallboard.WallBoard;
import net.kkura.wallboard.block.custom.ScreenBlock;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {


    public static final Block SCREEN_BLOCK =registerBlock("screen_block",
            properties -> new ScreenBlock(properties.strength(3f)));


    public static final Block BLOCK = registerBlock("block", RotatedPillarBlock::new);




    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(WallBoard.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(WallBoard.MOD_ID, name),
                toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(WallBoard.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(WallBoard.MOD_ID, name)))));

    }

    public static void registerModBlocks() {
        WallBoard.LOGGER.info("Registering mod blocks for " + WallBoard.MOD_ID);


    }
}
