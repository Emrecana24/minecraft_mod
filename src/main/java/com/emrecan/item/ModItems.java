package com.emrecan.item;

import com.emrecan.ExampleMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    // 🍋 Limon item'ı
    public static final Item LEMON = registerItem(
            "lemon",
            new Item.Settings()
                    .food(ModFoodComponents.LEMON)
    );

    /**
     * Bu metod item'ı Minecraft registry sistemine kaydeder
     */
    private static Item registerItem(String name, Item.Settings settings) {

        // emrecan:lemon gibi bir ID oluşturur
        Identifier id = Identifier.of(ExampleMod.MOD_ID, name);

        // 1.21+ için zorunlu registry key
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        // Ayarların içine registry key eklenir
        settings.registryKey(key);

        // Item oluşturulur
        Item item = new Item(settings);

        // Minecraft'a kayıt edilir
        return Registry.register(Registries.ITEM, key, item);
    }

    /**
     * Mod başlatılırken çağırılır
     */
    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering items for " + ExampleMod.MOD_ID);

        // 🍋 Limonu yaratıcı envantere ekle (Food & Drinks)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register(entries -> entries.add(LEMON));
    }
}
