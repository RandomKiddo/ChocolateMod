/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class EmeraldMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = {600, 800, 700, 600};
    private static final int[] PROTECTION_VALUES = {2, 3, 3, 2};
    @Override public int getDurability(EquipmentSlot slot) { return BASE_DURABILITY[slot.getEntitySlotId()]; }
    @Override public int getProtectionAmount(EquipmentSlot slot) { return PROTECTION_VALUES[slot.getEntitySlotId()]; }
    @Override public int getEnchantability() { return 1; }
    @Override public SoundEvent getEquipSound() { return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;  }
    @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.EMERALD); }
    @Override public String getName() { return "emerald"; }
    @Override public float getToughness() { return 2.0F; }
    @Override public float getKnockbackResistance() { return 0.02f; }
}
