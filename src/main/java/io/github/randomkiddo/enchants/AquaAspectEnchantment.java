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
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.player.PlayerEntity;

/**
 * AquaAspectEnchantment increases damage for Blazes, Endermen, and Magma Cubes
 *
 * Instantiation:
 * <code>
 *     AquaAspectEnchantment aquaAspect = new AquaAspectEnchantment();
 * </code>
 *
 * Overrides:
 * <code>
 *     getMaxLevel, getMinLevel, getMinPower, onTargetDamaged, canAccept
 * </code>
 *
 * @see Enchantment
 * @see BlazeEntity
 * @see EndermanEntity
 * @see MagmaCubeEntity
 */
public class AquaAspectEnchantment extends Enchantment {
    /**
     * Instantiates a new AquaAspectEnchantment with an common rarity for a weapon
     * @return A AquaAspectEnchantment Instance
     * @see net.minecraft.enchantment.Enchantment.Rarity
     * @see EnchantmentTarget
     */
    public AquaAspectEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND } );
    }
    /**
     * Gets the maximum possible level of the AquaAspectEnchantment
     * @return The value 2
     */
    @Override public int getMaxLevel() { return 2; }
    /**
     * Gets the minimum possible level of the AquaAspectEnchantment
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
     * @param level The level of the enchantment (1 or 2)
     */
    @Override public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof BlazeEntity || target instanceof EndermanEntity || target instanceof MagmaCubeEntity) {
            try {
                float damage = user.getMainHandStack().getDamage();;
                damage += (level / 2.0f) + 1.5f;
                target.damage(DamageSource.player((PlayerEntity)user), damage);
            } catch (ClassCastException classCastError) { /* pass */ }
        }
    }
    /**
     * Returns if this enchantment can be with another enchantment
     * @param other The Enchantment to check
     * @return true if yes, false if no
     * @see Enchantment
     */
    @Override public boolean canAccept(Enchantment other) { return !(other instanceof FireAspectEnchantment); }
}
