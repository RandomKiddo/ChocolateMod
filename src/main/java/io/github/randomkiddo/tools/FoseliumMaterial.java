/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import static io.github.randomkiddo.ores.IngotRegistry.FOSELIUM_INGOT;

/**
 * Allows for foselium ingots to be used as a tool material
 *
 * Implements all required methods in ToolMaterial
 *
 * @see ToolMaterial
 */
public class FoseliumMaterial implements ToolMaterial {
    /**
     * The public use-case instance of the material
     */
    public static final FoseliumMaterial INSTANCE = new FoseliumMaterial();

    /**
     * The durability of the material
     * @return The value 1800
     */
    @Override public int getDurability() { return 1800; }

    /**
     * Gets the mining speed multiplier for this material
     * @return The value 9.0F
     */
    @Override public float getMiningSpeedMultiplier() { return 9.0F; }

    /**
     * Gets the attack damage for this material
     * @return The value 2.0F
     */
    @Override public float getAttackDamage() { return 2.0F; }

    /**
     * Gets the mining level for this material
     * @return The value 5
     */
    @Override public int getMiningLevel() { return 5; }

    /**
     * Gets the enchantability of this material
     * @return The value 17
     */
    @Override public int getEnchantability() { return 17; }

    /**
     * Gets the repair ingredient for the material
     * @return The repair ingredient of the item
     * @see Ingredient
     */
    @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(FOSELIUM_INGOT); }
}
