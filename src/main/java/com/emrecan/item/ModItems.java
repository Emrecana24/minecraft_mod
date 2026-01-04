package com.emrecan.item;

import com.emrecan.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.emrecan.item.ModFoodComponents;

public class ModItems {

    // Limon item’ını burada TANIMLIYORUZ
    public static final Item LEMON = registerItem(
            "lemon",
            new Item(new Item.Settings().food(ModFoodComponents.LEMON))
    );

    // Item’ları Minecraft’a kaydeden metot
    private static Item registerItem(String name, Item item) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(ExampleMod.MOD_ID, name),
                item
        );
    }

    // Mod başlarken çağıracağımız metot
    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering items for " + ExampleMod.MOD_ID);
    }
}
