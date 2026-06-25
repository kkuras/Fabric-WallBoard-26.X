package net.kkura.wallboard.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.kkura.wallboard.block.ModBlocks;
import net.kkura.wallboard.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    private static final PropertyDispatch<VariantMutator> ROTATION_HORIZONTAL_FACING =
            PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                    .select(Direction.EAST, Y_ROT_90)
                    .select(Direction.SOUTH, Y_ROT_180)
                    .select(Direction.WEST, Y_ROT_270)
                    .select(Direction.NORTH, NOP);


    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        createOrientableBlock(ModBlocks.SCREEN_BLOCK, blockModelGenerators);


    }

    private void createOrientableBlock(Block block, BlockModelGenerators gen) {
        Identifier modelId = TexturedModel.ORIENTABLE.create(block, gen.modelOutput);
        MultiVariant model = plainVariant(modelId);
        gen.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block, model)
                        .with(ROTATION_HORIZONTAL_FACING)
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

        itemModelGenerators.generateFlatItem(ModItems.SCREEN, ModelTemplates.FLAT_ITEM);

    }
}
