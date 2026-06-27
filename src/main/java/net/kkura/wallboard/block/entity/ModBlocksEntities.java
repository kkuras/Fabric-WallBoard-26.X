package net.kkura.wallboard.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.kkura.wallboard.WallBoard;
import net.kkura.wallboard.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;


public class ModBlocksEntities {

    public static final BlockEntityType<ScreenBlockEntity> SCREEN_BLOCK_ENTITY =
            Registry.register(
                    BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(WallBoard.MOD_ID, "screen_block_entity"),
                    FabricBlockEntityTypeBuilder.create(ScreenBlockEntity::new, ModBlocks.SCREEN_BLOCK).build()
            );

    public static void registerModBlocksEntities() {
        WallBoard.LOGGER.info("Registering mod blocks entities for " + WallBoard.MOD_ID);
    }
}
