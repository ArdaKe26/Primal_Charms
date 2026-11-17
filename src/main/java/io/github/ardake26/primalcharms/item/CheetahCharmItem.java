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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CheetahCharmItem extends TrinketItem {
    private final float hungerCost;
    private final double speedBonus;

    public CheetahCharmItem(Item.Properties properties, double speedBonus, float hungerCost) {
        super(properties);
        this.hungerCost = hungerCost;
        this.speedBonus = speedBonus;
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot,
            LivingEntity entity, Identifier slotIdentifier) {
        Multimap<Holder<Attribute>, AttributeModifier> map = super.getModifiers(stack, slot, entity, slotIdentifier);

        map.put(Attributes.MOVEMENT_SPEED,
                new AttributeModifier(slotIdentifier, speedBonus,
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

        return map;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.level().isClientSide()) {
            if (entity instanceof Player player) {
                player.causeFoodExhaustion(hungerCost);
            }
        }
    }
}
