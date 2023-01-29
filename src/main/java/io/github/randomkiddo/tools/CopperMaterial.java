/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.tools;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import static io.github.randomkiddo.chocolates.ChocolateRegistry.CHOCOLATE;

/**
 * Allows for copper to be used as a tool material
 *
 * Implements all required methods in ToolMaterial
 *
 * @see ToolMaterial
 */
public class CopperMaterial implements ToolMaterial {
    /**
     * The public use-case instance of the material
     */
    public static final CopperMaterial INSTANCE = new CopperMaterial();

    /**
     * The durability of the material
     * @return The value 200
     */
    @Override public int getDurability() { return 200; }

    /**
     * Gets the mining speed multiplier for this material
     * @return The value 3.0F
     */
    @Override public float getMiningSpeedMultiplier() { return 3.0F; }

    /**
     * Gets the attack damage for this material
     * @return The value 2.0F
     */
    @Override public float getAttackDamage() { return 2.0F; }

    /**
     * Gets the mining level for this material
     * @return The value 2
     */
    @Override public int getMiningLevel() { return 2; }

    /**
     * Gets the enchantability of this material
     * @return The value 6
     */
    @Override public int getEnchantability() { return 6; }

    /**
     * Gets the repair ingredient for the material
     * @return The repair ingredient of the item
     * @see Ingredient
     */
    @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.COPPER_INGOT); }
}
