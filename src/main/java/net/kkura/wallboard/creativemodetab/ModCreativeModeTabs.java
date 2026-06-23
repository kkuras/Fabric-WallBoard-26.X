package net.kkura.wallboard.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.kkura.wallboard.WallBoard;
import net.kkura.wallboard.block.ModBlocks;
import net.kkura.wallboard.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {

    public static final CreativeModeTab WALLBOARD_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(WallBoard.MOD_ID, "wallboards"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCREEN))
                    .title(Component.translatable("creativemodetab.wallboard.wallboards"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.SCREEN_BLOCK);
                        output.accept(ModItems.SCREEN);

                    })
                    .build());


    public static void registerModCreativeModeTabs() {
        WallBoard.LOGGER.info("registring creative mode tab for " + WallBoard.MOD_ID);
    }
}
