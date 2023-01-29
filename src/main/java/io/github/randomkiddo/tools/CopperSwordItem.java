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
 * Makes custom behavior for a copper sword
 *
 * @see PickaxeItem
 */
public class CopperSwordItem extends PickaxeItem {
    private boolean isCharged;
    public int swingsLeft;
    public long lastSwing;
    /**
     * Instantiates a new copper sword item
     * @param material The tool material
     * @param attackDamage The attack damage the item does
     * @param attackSpeed The attack speed of the item
     * @param settings Related item settings
     */
    public CopperSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        this.isCharged = false;
        this.swingsLeft = 3;
        this.lastSwing = 0;
    }
    public void setCharged(boolean b) { this.isCharged = b; }
    public void reset() { this.isCharged = false; }
    public boolean isCharged() { return this.isCharged; }
    public boolean canSwing() { return this.lastSwing == 0 || System.currentTimeMillis() - this.lastSwing >= 625; }
}
