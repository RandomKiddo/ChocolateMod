/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.tools;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

/**
 * Since PickaxeItem's constructor is not public, this class extends the PickaxeItem class
 * to provide a constructor for the custom chocolate pickaxe item
 *
 * @see PickaxeItem
 */
public class ChocolatePickaxeItem extends PickaxeItem {
    /**
     * Instantiates a new chocolate pickaxe item
     * @param material The tool material
     * @param attackDamage The attack damage the item does
     * @param attackSpeed The attack speed of the item
     * @param settings Related item settings
     */
    public ChocolatePickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
