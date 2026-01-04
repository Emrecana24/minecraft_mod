package com.emrecan.item;

import com.emrecan.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item LEMON = registerItem(
            "lemon",
            new Item(new Item.Settings().food(ModFoodComponents.LEMON))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(
                Registries.ITEM,
                Identifier.of(ExampleMod.MOD_ID, name),
                item
        );
    }

    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering items for " + ExampleMod.MOD_ID);
    }
}
