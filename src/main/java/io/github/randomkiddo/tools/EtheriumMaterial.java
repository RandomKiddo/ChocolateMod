package io.github.randomkiddo.tools;
import io.github.randomkiddo.ores.IngotRegistry;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import javax.tools.Tool;

import static io.github.randomkiddo.chocolates.ChocolateRegistry.CHOCOLATE;

/**
 * Allows for etherium to be used as a tool material
 *
 * Implements all required methods in ToolMaterial
 *
 * @see ToolMaterial
 */
public class EtheriumMaterial implements ToolMaterial {
    /**
     * The public use-case instance of the material
     */
    public static final EtheriumMaterial INSTANCE = new EtheriumMaterial();

    /**
     * The durability of the material
     * @return The value 50
     */
    @Override public int getDurability() { return 50; }

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
    @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(IngotRegistry.ETHERIUM_INGOT); }

}
