/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
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
 * CorrosionResistance enchantment lowers the damage taken when in acid
 *
 * Instantiation:
 * <code>
 *     CorrosionResistanceEnchantment adrenaline = new CorrosionResistanceEnchantment();
 * </code>
 *
 * Overrides:
 * <code>
 *     getMaxLevel, getMinLevel, getMinPower, canAccept
 * </code>
 *
 * @see Enchantment
 * @see StatusEffectInstance
 */
public class CorrosionResistanceEnchantment extends Enchantment {
    /**
     * Instantiates a new CorrosionResistanceEnchantment with a rare rarity for armor
     * @return A AdrenalineEnchantment Instance
     * @see net.minecraft.enchantment.Enchantment.Rarity
     * @see EnchantmentTarget
     */
    public CorrosionResistanceEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[] { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET });
    }
    /**
     * Gets the maximum possible level of the CorrosionResistanceEnchantment
     * @return The value 1
     */
    @Override public int getMaxLevel() { return 3; }
    /**
     * Gets the minimum possible level of the CorrosionResistanceEnchantment
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
     * Returns if this enchantment can be with another enchantment
     * @param other The Enchantment to check
     * @return true if yes, false if no
     * @see Enchantment
     */
    @Override public boolean canAccept(Enchantment other) { return true; }
}
