package com.emrecan.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent LEMON = new FoodComponent.Builder()
            .nutrition(2)              // açlık
            .saturationModifier(0.3f)   // doygunluk
            .build();
}
