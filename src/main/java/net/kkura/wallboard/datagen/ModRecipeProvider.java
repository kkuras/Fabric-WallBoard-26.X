package net.kkura.wallboard.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kkura.wallboard.block.ModBlocks;
import net.kkura.wallboard.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
        return new RecipeProvider(provider, output) {
            @Override
            public void buildRecipes() {

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCREEN_BLOCK, 4)
                        .pattern("WWW")
                        .pattern("RSR")
                        .pattern("WWW")
                        .define('W', Blocks.OAK_PLANKS)
                        .define('R', Items.REDSTONE)
                        .define('S', ModItems.SCREEN)
                        .unlockedBy(getHasName(Blocks.OAK_PLANKS), has(Blocks.OAK_PLANKS))
                        .group("redstone")
                        .save(output);

                shaped(RecipeCategory.REDSTONE, ModItems.SCREEN, 6)
                        .pattern(" I ")
                        .pattern("PRP")
                        .pattern(" I ")
                        .define('R', Items.REDSTONE)
                        .define('I', Items.IRON_INGOT)
                        .define('P', Items.GLASS_PANE)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("redstone")
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "WallBoard Recipes";
    }
}
