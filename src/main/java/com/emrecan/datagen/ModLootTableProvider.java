package com.emrecan.datagen;

import com.emrecan.ExampleMod;
import com.emrecan.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModLootTableProvider extends FabricLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> consumer) {

        addVillageChest(consumer, "village_plains_house");
        addVillageChest(consumer, "village_desert_house");
        addVillageChest(consumer, "village_savanna_house");
        addVillageChest(consumer, "village_snowy_house");
        addVillageChest(consumer, "village_taiga_house");
    }

    private void addVillageChest(
            BiConsumer<RegistryKey<LootTable>, LootTable.Builder> consumer,
            String chestName
    ) {
        RegistryKey<LootTable> table = RegistryKey.of(
                RegistryKeys.LOOT_TABLE,
                Identifier.of("minecraft", "chests/village/" + chestName)
        );

        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 1))
                // PATATES
                .with(ItemEntry.builder(Items.POTATO)
                        .weight(10)
                        .apply(SetCountLikePotato()))
                // LİMON
                .with(ItemEntry.builder(ModItems.LEMON)
                        .weight(10)
                        .apply(SetCountLikePotato()));

        consumer.accept(table, LootTable.builder().pool(pool));
    }

    private static net.minecraft.loot.function.LootFunction.Builder SetCountLikePotato() {
        return net.minecraft.loot.function.SetCountLootFunction.builder(
                UniformLootNumberProvider.create(1.0f, 7.0f)
        );
    }
}