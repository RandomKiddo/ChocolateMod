/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
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

public class VampireEnchantment extends Enchantment {
    public VampireEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
    }
    @Override public int getMaxLevel() { return 3; }
    @Override public int getMinLevel() { return 1; }
    @Override public int getMinPower(int level) { return 1; }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        float damage = user.getMainHandStack().getDamage();
        float healAmount = damage * (.05f * level);
        user.heal(healAmount);
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof DamageEnchantment);
    }
}
