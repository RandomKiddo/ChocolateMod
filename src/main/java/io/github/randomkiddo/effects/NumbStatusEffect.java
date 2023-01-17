/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

/**
 * Numb status effect prevents the user from taking damage, then they take all of it at once
 *
 * Overrides:
 * <code>
 *     canApplyUpdateEffect, applyUpdateEffect, isInstant, onRemove
 * </code>
 *
 * @see StatusEffect
 */
public class NumbStatusEffect extends StatusEffect {
    /**
     * The total saved damage to take
     */
    private float totalDamage;
    /**
     * Instantiates a new numb status effect
     */
    public NumbStatusEffect() { super(StatusEffectCategory.HARMFUL, 0x47007d); this.totalDamage = 0.0f; }

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
        super.applyUpdateEffect(entity, amplifier);
    }

    /**
     * Returns if this effect is instant
     * @return true is yes, false if no
     */
    @Override public boolean isInstant() { return false; }

    /**
     * Specifies what to do once this effect is removed
     * @param entity The living entity
     * @param attributes Attributes
     * @param amplifier The effect amplifier
     */
    @Override public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.damage(DamageSource.GENERIC, this.totalDamage);
        super.onRemoved(entity, attributes, amplifier);
    }
}
