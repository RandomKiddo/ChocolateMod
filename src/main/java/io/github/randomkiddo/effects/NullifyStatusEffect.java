/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

/**
 * Nullify status effect removes all active status effects while this effect is active
 *
 * Overrides:
 * <code>
 *     canApplyUpdateEffect, applyUpdateEffect, isInstant
 * </code>
 *
 * @see StatusEffect
 */
public class NullifyStatusEffect extends StatusEffect {
    /**
     * Instantiates a new nullify status effect
     */
    public NullifyStatusEffect() { super(StatusEffectCategory.NEUTRAL, 0x000000); }

    /**
     * Returns if this effect's update effect can be applied
     * @param duration The duration of the effect
     * @param amplifier The effect amplifier
     * @return true if yes, false if no
     */
    @Override public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }

    /**
     * Apply this effect's update effect
     * @param entity The entity to update
     * @param amplifier The effect's amplifier
     */
    @Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        for (StatusEffect effect : entity.getActiveStatusEffects().keySet()) {
            if (!effect.getClass().equals(NullifyStatusEffect.class)) {
                entity.removeStatusEffect(effect);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    /**
     * Returns if this effect is instant
     * @return true is yes, false if no
     */
    @Override public boolean isInstant() { return false; }
}
