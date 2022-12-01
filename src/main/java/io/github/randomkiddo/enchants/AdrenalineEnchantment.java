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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class AdrenalineEnchantment extends Enchantment {
    public AdrenalineEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[] { EquipmentSlot.HEAD });
    }
    @Override public int getMaxLevel() { return 1; }
    @Override public int getMinLevel() { return 1; }
    @Override public int getMinPower(int level) { return 1; }
    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 2 * level, 0));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 2 * level, 0));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * level, 0));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20, 0));
        super.onUserDamaged(user, attacker, level);
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof LightweightEnchantment);
    }
}
