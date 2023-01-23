/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

/**
 * Defines the protocol for the material of the slime armor
 *
 * Overrides:
 * <code>
 *     getDurability, getProtectionAmount, getEnchantability, getEquipSound,
 *     get RepairIngredient, getName, getToughness, getKnockbackResistance
 * </code>
 *
 * @see ArmorMaterial
 */
public class SlimeMaterial implements ArmorMaterial {
    /**
     * Base durability of emerald armor
     */
    private static final int[] BASE_DURABILITY = {100};
    /**
     * Protection values of emerald armor
     */
    private static final int[] PROTECTION_VALUES = {2};

    /**
     * Gets a durability value given an equipment slot
     * @param slot The given equipment slot
     * @return The durability value
     */
    @Override public int getDurability(EquipmentSlot slot) { return BASE_DURABILITY[slot.getEntitySlotId()]; }

    /**
     * Get the protection value given an equipment slot
     * @param slot The given equipment slot
     * @return The protection amount
     */
    @Override public int getProtectionAmount(EquipmentSlot slot) { return PROTECTION_VALUES[slot.getEntitySlotId()]; }

    /**
     * Gets the enchantability factor of emerald armor
     * @return The value 1
     */
    @Override public int getEnchantability() { return 1; }

    /**
     * Specifies which sound to play when equipping the armor
     * @return Default armor equip sound of diamond armor
     */
    @Override public SoundEvent getEquipSound() { return SoundEvents.BLOCK_SLIME_BLOCK_PLACE;  }

    /**
     * Gets the ingredient required to repair emerald armor
     * @return Ingredient form of Items.SLIME_BALL
     * @see Items
     */
    @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.SLIME_BALL); }

    /**
     * Fetches the name
     * @return A string representing material name
     */
    @Override public String getName() { return "slime"; }

    /**
     * Gets the toughness of this armor
     * @return A float value of 2.0F
     */
    @Override public float getToughness() { return 2.0F; }

    /**
     * Gets the knockback resistance value of this armor
     * @return A float value of .02f
     */
    @Override public float getKnockbackResistance() { return 0.02f; }
}
