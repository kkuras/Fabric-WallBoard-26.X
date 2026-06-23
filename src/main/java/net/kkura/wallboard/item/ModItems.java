package net.kkura.wallboard.item;

import net.kkura.wallboard.WallBoard;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {


    public static final Item SCREEN = registerItem("screen", Item::new);


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(WallBoard.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,
                        Identifier.fromNamespaceAndPath(WallBoard.MOD_ID, name)))));
    }

    public static void registerModItems() {
        WallBoard.LOGGER.info("Registering mod items for" + WallBoard.MOD_ID);

    }
}
