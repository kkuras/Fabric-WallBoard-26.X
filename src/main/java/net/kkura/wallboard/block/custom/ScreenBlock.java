package net.kkura.wallboard.block.custom;

import net.minecraft.core.BlockPos;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ScreenBlock extends Block {
    public ScreenBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        if (!player.isShiftKeyDown()) {
            level.addParticle(ParticleTypes.GLOW, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 1, 0);
        }

        if (player.isShiftKeyDown()) {
            level.playSound(player, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 2f, 1f);
        }

        return InteractionResult.SUCCESS;
    }
}
