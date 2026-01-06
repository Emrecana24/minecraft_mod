package com.emrecan;

import com.emrecan.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {

	public static final String MOD_ID = "emrecan";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		// Item kayıtları
		ModItems.registerModItems();

		// Vanilla loot tablolarını BOZMADAN limon ekleme
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

			// Sadece vanilla (minecraft) loot tabloları
			if (!source.isBuiltin()) return;

			// Sadece köy ev sandıkları
			if (!isVillageHouseChest(key)) return;

			LootPool.Builder lemonPool = LootPool.builder()
					.rolls(UniformLootNumberProvider.create(1, 1))
					.with(ItemEntry.builder(ModItems.LEMON)
							.apply(SetCountLootFunction.builder(
									UniformLootNumberProvider.create(1.0f, 7.0f)
							)));

			tableBuilder.pool(lemonPool);
		});

		LOGGER.info("Emrecan Mod yüklendi. Limonlar köy sandıklarında!");
	}

	/**
	 * Hedeflediğimiz köy sandıkları
	 */
	private static boolean isVillageHouseChest(RegistryKey<LootTable> key) {
		Identifier id = key.getValue();

		return id.equals(Identifier.of("minecraft", "chests/village/village_plains_house"))
				|| id.equals(Identifier.of("minecraft", "chests/village/village_desert_house"))
				|| id.equals(Identifier.of("minecraft", "chests/village/village_savanna_house"))
				|| id.equals(Identifier.of("minecraft", "chests/village/village_snowy_house"))
				|| id.equals(Identifier.of("minecraft", "chests/village/village_taiga_house"));
	}
}