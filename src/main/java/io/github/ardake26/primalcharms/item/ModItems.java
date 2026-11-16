package io.github.ardake26.primalcharms.item;

import java.util.function.Function;

import io.github.ardake26.primalcharms.PrimalCharms;
import io.github.ardake26.primalcharms.ModConstants.CHEETAH_CHARM_CONSTANTS;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item CHEETAH_CHARM = registerItem(CHEETAH_CHARM_CONSTANTS.ITEM_ID,
            new Item.Properties().stacksTo(CHEETAH_CHARM_CONSTANTS.STACK_SIZE), CheetahCharmItem::new);

    private static Item registerItem(String itemName, Item.Properties properties,
            Function<Item.Properties, Item> factory) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, PrimalCharms.id(itemName));
        properties.setId(key);
        Item item = factory.apply(properties);
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void initialize() {
    }
}
