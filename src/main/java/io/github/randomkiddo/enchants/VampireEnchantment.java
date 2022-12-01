/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ToolMaterial;

/**
 * VampireEnchantment heals the user once an entity is damaged
 *
 * Instantiation:
 * <code>
 *     VampireEnchantment vampire = new VampireEnchantment();
 * </code>
 *
 * Overrides:
 * <code>
 *     getMaxLevel, getMinLevel, getMinPower, onTargetDamaged, canAccept
 * </code>
 *
 * @see Enchantment
 */
public class VampireEnchantment extends Enchantment {
    /**
     * Instantiates a new VampireEnchantment with an very rare rarity for a weapon
     * @return A VampireEnchantment Instance
     * @see net.minecraft.enchantment.Enchantment.Rarity
     * @see EnchantmentTarget
     */
    public VampireEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
    }

    /**
     * Gets the maximum possible level of the VampireEnchantment
     * @return The value 3
     */
    @Override public int getMaxLevel() { return 3; }
    /**
     * Gets the minimum possible level of the VampireEnchantment
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
     * Specifies what happens with this enchantment on an entity being damaged
     * @param user The user with the enchantment
     * @param target The target damaged
     * @param level The level of the enchantment (1, 2, or 3)
     */
    @Override public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        float damage = user.getMainHandStack().getDamage();
        float healAmount = damage * (.05f * level);
        user.heal(healAmount);
    }

    /**
     * Returns if this enchantment can be with another enchantment
     * @param other The Enchantment to check
     * @return true if yes, false if no
     * @see Enchantment
     */
    @Override public boolean canAccept(Enchantment other) { return !(other instanceof DamageEnchantment); }
}
