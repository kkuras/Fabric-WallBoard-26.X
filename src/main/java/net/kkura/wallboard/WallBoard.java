package net.kkura.wallboard;

import net.fabricmc.api.ModInitializer;

import net.kkura.wallboard.block.ModBlocks;
import net.kkura.wallboard.creativemodetab.ModCreativeModeTabs;
import net.kkura.wallboard.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WallBoard implements ModInitializer {
	public static final String MOD_ID = "wallboard";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}

}
