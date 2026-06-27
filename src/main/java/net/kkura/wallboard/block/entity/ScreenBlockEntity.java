package net.kkura.wallboard.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ScreenBlockEntity extends BlockEntity {
    public ScreenBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocksEntities.SCREEN_BLOCK_ENTITY, pos, state);
    }
}
