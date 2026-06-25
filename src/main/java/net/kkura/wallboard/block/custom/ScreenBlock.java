package net.kkura.wallboard.block.custom;

import net.minecraft.core.BlockPos;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

public class ScreenBlock extends Block {
    public ScreenBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        Direction clicked = hitResult.getDirection();

        if (clicked != facing) {
            return InteractionResult.PASS;
        }

        if (!player.isShiftKeyDown()) {
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 1, 1, 0);
        } else if (player.isShiftKeyDown()) {
            level.playSound(player, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 2f, 1f);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }
}
