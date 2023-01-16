/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo
 */

package io.github.randomkiddo.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

/**
 * AdrenalineEnchantment adds a short duration of Speed, Haste, Strength, and Saturation when damaged
 *
 * Instantiation:
 * <code>
 *     AdrenalineEnchantment adrenaline = new AdrenalineEnchantment();
 * </code>
 *
 * Overrides:
 * <code>
 *     getMaxLevel, getMinLevel, getMinPower, onUserDamaged, canAccept
 * </code>
 *
 * @see Enchantment
 * @see StatusEffectInstance
 */
public class AdrenalineEnchantment extends Enchantment {
    /**
     * Instantiates a new AdrenalineEnchantment with a very rare rarity for armor
     * @return A AdrenalineEnchantment Instance
     * @see net.minecraft.enchantment.Enchantment.Rarity
     * @see EnchantmentTarget
     */
    public AdrenalineEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[] { EquipmentSlot.HEAD });
    }
    /**
     * Gets the maximum possible level of the AdrenalineEnchantment
     * @return The value 1
     */
    @Override public int getMaxLevel() { return 1; }
    /**
     * Gets the minimum possible level of the AdrenalineEnchantment
     * @return The value 1
     */
    @Override public int getMinLevel() { return 1; }
    /**
     * Gets the minimum power level for a given level
     * @param level The given level
     * @return The value 1
     */
    @Override public int getMinPower(int level) { return 1; }

    /**
     * Specifies what happens with this enchantment when the user is damaged
     * @param user The user being damaged
     * @param attacker The entity attacking
     * @param level The enchantment level (1)
     */
    @Override public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 2 * level, 0));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 2 * level, 0));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * level, 0));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20, 0));
        super.onUserDamaged(user, attacker, level);
    }
    /**
     * Returns if this enchantment can be with another enchantment
     * @param other The Enchantment to check
     * @return true if yes, false if no
     * @see Enchantment
     */
    @Override public boolean canAccept(Enchantment other) { return !(other instanceof LightweightEnchantment); }
}
