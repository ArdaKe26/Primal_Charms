package io.github.ardake26.primalcharms.item;

import com.google.common.collect.Multimap;

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

public class BearCharmItem extends TrinketItem {
    private final double maxHealth;
    private final double knockbackResistance;
    private final double speedCost;

    public BearCharmItem(Item.Properties properties, double maxHealth, double knockbackResistance, double speedCost) {
        super(properties);
        this.knockbackResistance = knockbackResistance;
        this.maxHealth = maxHealth;
        this.speedCost = speedCost;
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot,
            LivingEntity entity, Identifier slotIdentifier) {
        Multimap<Holder<Attribute>, AttributeModifier> map = super.getModifiers(stack, slot, entity, slotIdentifier);

        map.put(Attributes.MAX_HEALTH,
                new AttributeModifier(slotIdentifier, maxHealth, AttributeModifier.Operation.ADD_VALUE));
        map.put(Attributes.KNOCKBACK_RESISTANCE,
                new AttributeModifier(slotIdentifier, knockbackResistance,
                        AttributeModifier.Operation.ADD_VALUE));
        if (speedCost != 0) {
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(slotIdentifier, speedCost, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        }

        return map;
    }
}
