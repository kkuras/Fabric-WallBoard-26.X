package net.kkura.wallboard;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.kkura.wallboard.datagen.ModBlockLootTableProvider;
import net.kkura.wallboard.datagen.ModBlockTagsProvider;
import net.kkura.wallboard.datagen.ModModelProvider;
import net.kkura.wallboard.datagen.ModRecipeProvider;

public class WallBoardDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
