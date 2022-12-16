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
 * Freeze status effect freezes the current entity
 *
 * Overrides:
 * <code>
 *     canApplyUpdateEffect, applyUpdateEffect, isInstant
 * </code>
 *
 * @see StatusEffect
 */
public class FreezeStatusEffect extends StatusEffect {
    /**
     * Checks if this update is the first time
     */
    private boolean first = true;
    /**
     * The coordinates of the freeze location
     */
    private double x, y, z;

    /**
     * Instantiates a new freeze status effect
     */
    public FreezeStatusEffect() { super(StatusEffectCategory.NEUTRAL, 0x00ffff); }
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
        if (!entity.world.isClient()) {
            if (first) {
                this.x = entity.getX();
                this.y = entity.getY();
                this.z = entity.getZ();
                first = false;
            }
            entity.teleport(this.x, this.y, this.z);
            entity.setVelocity(0, 0,0);
        }
        super.applyUpdateEffect(entity, amplifier);
    }
    /**
     * Returns if this effect is instant
     * @return true is yes, false if no
     */
    @Override public boolean isInstant() { return false; }
}
