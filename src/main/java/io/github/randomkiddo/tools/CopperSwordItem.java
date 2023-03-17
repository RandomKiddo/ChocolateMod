/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.tools;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

/**
 * Makes custom behavior for a copper sword
 *
 * @see SwordItem
 */
public class CopperSwordItem extends SwordItem {
    /**
     * If the sword is charged
     */
    private boolean isCharged;
    /**
     * Charged swings left
     */
    public int swingsLeft = 3;
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
    }

    /**
     * Set charge status
     * @param b Charge boolean
     */
    public void setCharged(boolean b) { this.isCharged = b; }

    /**
     * Reset the sword
     */
    public void reset() { this.isCharged = false; this.swingsLeft = 3; }

    /**
     * Strike with lightning post hit
     * @param stack The item
     * @param target The entity target
     * @param attacker The entity attacker
     * @return Result boolean
     */
    @Override public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (this.isCharged && this.swingsLeft > 0) {
            LightningEntity le = new LightningEntity(EntityType.LIGHTNING_BOLT, attacker.getWorld());
            le.setPosition(target.getPos());
            attacker.getWorld().spawnEntity(le);
            --this.swingsLeft;
        }
        if (this.swingsLeft == 0) { this.reset(); }
        return super.postHit(stack, target, attacker);
    }
}
