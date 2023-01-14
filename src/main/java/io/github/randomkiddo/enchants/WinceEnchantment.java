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
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

/**
 * WinceEnchantment adds a slowness effect to the target entity damaged
 *
 * Instantiation:
 * <code>
 *     WinceEnchantment wince = new WinceEnchantment();
 * </code>
 *
 * Overrides:
 * <code>
 *     getMaxLevel, getMinLevel, getMinPower, onTargetDamaged
 * </code>
 *
 * @see Enchantment
 */
public class WinceEnchantment extends Enchantment {
    /**
     * Instantiates a new WinceEnchantment with an uncommon rarity for a bow
     * @return A WinceEnchantment Instance
     * @see net.minecraft.enchantment.Enchantment.Rarity
     * @see EnchantmentTarget
     */
    public WinceEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.BOW, new EquipmentSlot[] {
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND } );
    }

    /**
     * Gets the maximum possible level of the WinceEnchantment
     * @return The value 2
     */
    @Override public int getMaxLevel() { return 2; }

    /**
     * Gets the minimum possible level of the WinceEnchantment
     * @return The value 1
     */
    @Override public int getMinLevel() { return 1; }

    /**
     * Returns the minimum power level for a given level
     * @param level The given level
     * @return The value 1
     */
    @Override public int getMinPower(int level) { return 1; }

    /**
     * Specifies what happens with this enchantment on an entity being damaged
     * @param user The user with the enchantment
     * @param target The target damaged
     * @param level The level of the enchantment (1 or 2)
     */
    @Override public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            ((LivingEntity)target).addStatusEffect(
                    new StatusEffectInstance(StatusEffects.SLOWNESS, 20*2*level, level-1)
            );
        }
    }
}