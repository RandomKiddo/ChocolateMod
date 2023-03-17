/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import static io.github.randomkiddo.chocolates.ChocolateRegistry.CHOCOLATE;

/**
 * Allows for chocolate to be used as a tool material
 *
 * Implements all required methods in ToolMaterial
 *
 * @see ToolMaterial
 */
public class ChocolateMaterial implements ToolMaterial {
    /**
     * The public use-case instance of the material
     */
    public static final ChocolateMaterial INSTANCE = new ChocolateMaterial();

    /**
     * The durability of the material
     * @return The value 50
     */
    @Override public int getDurability() { return 50; }

    /**
     * Gets the mining speed multiplier for this material
     * @return The value 2.0F
     */
    @Override public float getMiningSpeedMultiplier() { return 2.0F; }

    /**
     * Gets the attack damage for this material
     * @return The value 2.0F
     */
    @Override public float getAttackDamage() { return 2.0F; }

    /**
     * Gets the mining level for this material
     * @return The value 1
     */
    @Override public int getMiningLevel() { return 1; }

    /**
     * Gets the enchantability of this material
     * @return The value 8
     */
    @Override public int getEnchantability() { return 8; }

    /**
     * Gets the repair ingredient for the material
     * @return The repair ingredient of the item
     * @see Ingredient
     */
    @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(CHOCOLATE); }
}
