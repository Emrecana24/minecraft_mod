package com.emrecan.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent LEMON = new FoodComponent.Builder()
            .nutrition(2)        // Açlık barı (1 = yarım et)
            .saturationModifier(0.3f) // Doygunluk
            .build();
}
