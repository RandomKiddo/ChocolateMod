package io.github.randomkiddo.tools;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

/**
 * Makes custom behavior for a Etherium sword
 *
 * @see SwordItem
 */
public class EtheriumSwordItem extends SwordItem{

    /**
     * Counts Number of hits
     */
    private int hits;

    /**
     * Instantiates a new etherium sword item
     * @param material The tool material
     * @param attackDamage The attack damage the item does
     * @param attackSpeed The attack speed of the item
     * @param settings Related item settings
     */
    public EtheriumSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        hits = 0;
    }

    /**
     *
     * @param attacker use it to clear attackers effects
     */
    public void reset(LivingEntity attacker) { this.hits = 0; attacker.clearStatusEffects(); }

    /**
     * Give speed, strength, and regen after a certain amount of hits
     * @param stack The item
     * @param target The entity target
     * @param attacker The entity attacker
     * @return Result boolean
     */
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (this.hits >= 10) {
            // Add regen
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20000, 1));
        } else if (this.hits >= 7) {
            // Add strength
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20000, 2));
        } else if (this.hits >= 4) {
            // Add speed
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20000, 2));
        }

        this.hits++;
        if (this.hits == 20) { this.reset(attacker); }
        return super.postHit(stack, target, attacker);
    }

}
