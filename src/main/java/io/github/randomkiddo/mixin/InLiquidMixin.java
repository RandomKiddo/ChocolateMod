/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * InAcidMixin is a spongepowered mixin for Minecraft that detects if an entity is in liquid,
 * and then follows the corresponding code
 *
 * Injected into <code>isTouchingWater</code> at <code>RETURN</code>
 * Non-cancellable
 *
 * @see Mixin
 * @see Inject
 * @see At
 * @see Entity
 */
@Mixin(Entity.class)
public class InLiquidMixin {
    /**
     * Injects the specified code into isTouchingWater
     * @param cir The callback info of the method and its returned boolean value
     * @see Entity
     */
    @Inject(method="isTouchingWater()Z", at=@At("RETURN"), cancellable=false)
    private void mixin(CallbackInfoReturnable<Boolean> cir) {
        Entity entity = (Entity)(Object)this;
        String name = entity.getBlockStateAtPos().getBlock().getName().toString();
        if (cir.getReturnValue() && name.contains("block.chocolate.acid")) {
            if (entity instanceof PlayerEntity pe) {
                ItemStack[] armor = { pe.getInventory().getArmorStack(0), pe.getInventory().getArmorStack(1),
                        pe.getInventory().getArmorStack(2), pe.getInventory().getArmorStack(3) };
                AtomicReference<Float> totalDamage = new AtomicReference<>(0.0f);
                for (ItemStack item : armor) {
                    AtomicBoolean changed = new AtomicBoolean(false);
                    item.getEnchantments().forEach(element -> {
                        String str = element.toString();
                        int index = str.indexOf("corrosion_resistance");
                        if (index != -1) {
                            for (int i = index + "corrosion_resistance".length(); i < str.length(); ++i) {
                                try {
                                    int lvl = Integer.parseInt(str.charAt(i) + "");
                                    totalDamage.updateAndGet(v -> v + (3.75f - (float)lvl));
                                    changed.set(true);
                                    break;
                                } catch (Exception e) {
                                    /* do nothing */
                                }
                            }
                        } else {
                            totalDamage.updateAndGet(v -> v + 3.75f);
                            changed.set(true);
                        }
                    });
                    if (!changed.get()) {
                        totalDamage.updateAndGet(v -> v + 3.75f);
                    }
                }
                if ((int)(float)totalDamage.get() == 0) { totalDamage.updateAndGet(v -> 15.0f); }
                pe.damage(DamageSource.GENERIC, (float)totalDamage.get());
            } else {
                entity.damage(DamageSource.GENERIC, 15.0f);
            }
        } else if (cir.getReturnValue() && name.contains("block.chocolate.soap")) {
            try {
                LivingEntity le = (LivingEntity)entity;
                Collection<StatusEffectInstance> collection = le.getStatusEffects();
                for (int i = 0; i < collection.size(); ++i) {
                    StatusEffectInstance instance = (StatusEffectInstance)collection.toArray()[i];
                    if (!instance.getEffectType().isBeneficial()) {
                        le.removeStatusEffect(instance.getEffectType());
                    }
                }
            } catch (ClassCastException cce) {
                /* do nothing */
            }
        }
    }
}
