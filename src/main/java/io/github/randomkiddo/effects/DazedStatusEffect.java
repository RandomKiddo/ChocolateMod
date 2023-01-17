package io.github.randomkiddo.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class DazedStatusEffect extends StatusEffect {

    public DazedStatusEffect() { super(StatusEffectCategory.HARMFUL, 0x3f3f42); }

    @Override public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }

    @Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            if (((PlayerEntity) entity).isCreative()) {
                return;
            }

            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 40));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40));
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override public boolean isInstant() { return false; }

}
