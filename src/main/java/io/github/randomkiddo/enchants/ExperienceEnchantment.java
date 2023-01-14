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
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;

/**
 * ExperienceEnchantment buffs experience gained when an entity is killed
 *
 * Instantiation:
 * <code>
 *     ExperienceEnchantment experience = new ExperienceEnchantment();
 * </code>
 *
 * Overrides:
 * <code>
 *     getMaxLevel, getMinLevel, getMinPower, onTargetDamaged
 * </code>
 *
 * @see Enchantment
 */
public class ExperienceEnchantment extends Enchantment {
    /**
     * The user's last experience amount
     */
    private int lastExperienceAmount;

    /**
     * Instantiates a new ExperienceEnchantment with an common rarity for a weapon
     * @return An ExperienceEnchantment Instance
     * @see net.minecraft.enchantment.Enchantment.Rarity
     * @see EnchantmentTarget
     */
    public ExperienceEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND } );
    }
    /**
     * Gets the maximum possible level of the ExperienceEnchantment
     * @return The value 5
     */
    @Override public int getMaxLevel() { return 5; }
    /**
     * Gets the minimum possible level of the VampireEnchantment
     * @return The value 1
     */
    @Override public int getMinLevel() { return 1; }
    /**
     * Gets the minimum power for a given level
     * @param level The given level
     * @return The value 1
     */
    @Override public int getMinPower(int level) { return 1; }

    /**
     * Specifies what happens with this enchantment on an entity being damaged
     * @param user The user with the enchantment
     * @param target The target damaged
     * @param level The level of the enchantment (1, 2, 3, 4, or 5)
     */
    @Override public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof MobEntity && ((MobEntity)(target)).isDead()) {
            int expGained = this.lastExperienceAmount - ((PlayerEntity)user).totalExperience;
            int expAdd = (int)(.1 * level * expGained) + (int)(Math.random() * 5);
            ((PlayerEntity)user).addExperience(expAdd);
        } else {
            this.lastExperienceAmount = ((PlayerEntity)user).totalExperience;
        }
    }
}
