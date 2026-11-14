package io.github.ardake26.primalcharms.item;

import io.github.ardake26.primalcharms.PrimalCharms;
import io.github.ardake26.primalcharms.ModConstants.CHEETAH_CAHRM_CONSTANTS;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item CHEETAH_CHARM = registerItem(CHEETAH_CAHRM_CONSTANTS.ItemID,
            new Item.Properties().stacksTo(CHEETAH_CAHRM_CONSTANTS.stackSize));

    private static Item registerItem(String itemName, Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, PrimalCharms.id(itemName));
        properties.setId(key);
        Item item = new Item(properties);
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void initialize() {
    }
}
