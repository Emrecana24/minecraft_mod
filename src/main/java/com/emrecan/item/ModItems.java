package com.emrecan.item;

import com.emrecan.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item LEMON = registerItem("lemon");

    private static Item registerItem(String name) {
        Identifier id = Identifier.of(ExampleMod.MOD_ID, name);

        return Registry.register(
                Registries.ITEM,
                id,
                new Item(
                        new Item.Settings()
                                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id))
                                .food(ModFoodComponents.LEMON)
                )
        );
    }

    public static void registerModItems() {
        // Şu an boş olması NORMAL
    }
}
