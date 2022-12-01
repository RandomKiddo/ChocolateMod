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
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.player.PlayerEntity;

public class AquaAspectEnchantment extends Enchantment {
    public AquaAspectEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND } );
    }
    @Override public int getMaxLevel() { return 2; }
    @Override public int getMinLevel() { return 1; }
    @Override public int getMinPower(int level) { return 1; }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof BlazeEntity || target instanceof EndermanEntity || target instanceof MagmaCubeEntity) {
            try {
                float damage = user.getMainHandStack().getDamage();;
                damage += (level / 2.0f) + 1.5f;
                target.damage(DamageSource.player((PlayerEntity)user), damage);
            } catch (ClassCastException classCastError) { /* pass */ }
        }
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof FireAspectEnchantment);
    }
}
