/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 */

package io.github.randomkiddo.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class WinceEnchantment extends Enchantment {
    public WinceEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.BOW, new EquipmentSlot[] {
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND } );
    }
    @Override
    public int getMaxLevel() { return 2; }
    @Override
    public int getMinLevel() { return 1; }
    @Override
    public int getMinPower(int level) { return 1; }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            ((LivingEntity)target).addStatusEffect(
                    new StatusEffectInstance(StatusEffects.SLOWNESS, 20*2*level, level-1)
            );
        }
    }
}