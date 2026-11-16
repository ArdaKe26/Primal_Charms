package io.github.ardake26.primalcharms.item;

import com.google.common.collect.Multimap;

import static io.github.ardake26.primalcharms.ModConstants.CHEETAH_CHARM_CONSTANTS.*;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CheetahCharmItem extends TrinketItem {
    public CheetahCharmItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot,
            LivingEntity entity, Identifier slotIdentifier) {
        Multimap<Holder<Attribute>, AttributeModifier> map = super.getModifiers(stack, slot, entity, slotIdentifier);

        map.put(Attributes.MOVEMENT_SPEED,
                new AttributeModifier(slotIdentifier, CHEETAH_CHARM_SPEED_BUFF,
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

        return map;
    }
}
