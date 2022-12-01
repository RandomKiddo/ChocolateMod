/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 */

package io.github.randomkiddo.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;

public class ExperienceEnchantment extends Enchantment {
    private int lastExperienceAmount;
    public ExperienceEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND } );
    }
    @Override public int getMaxLevel() { return 5; }
    @Override public int getMinLevel() { return 1; }
    @Override public int getMinPower(int level) { return 1; }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof MobEntity && ((MobEntity)(target)).isDead()) {
            int expGained = this.lastExperienceAmount - ((PlayerEntity)user).totalExperience;
            int expAdd = (int)(.1 * level * expGained) + (int)(Math.random() * 5);
            ((PlayerEntity)user).addExperience(expAdd);
        } else {
            this.lastExperienceAmount = ((PlayerEntity)user).totalExperience;
        }
    }
}
