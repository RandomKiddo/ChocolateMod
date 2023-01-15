/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo
 */

package io.github.randomkiddo.mixin;

import io.github.randomkiddo.effects.NumbStatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Field;

/**
 * NumbDamageTrackerMixin is a spongepowered mixin for Minecraft that prevents the user from taking damage
 * while the user has the numb effect, but uses Java Reflection to set the damage to be taken later
 *
 * Injected into <code>damage</code> at <code>HEAD</code>
 * Cancellable (required)
 *
 * @see Mixin
 * @see Inject
 * @see At
 * @see LivingEntity
 */
@Mixin(LivingEntity.class)
public class NumbDamageTrackerMixin {
    /**
     * Injects the specified code into damage method
     * @param source The damage source
     * @param amount The damage amount
     * @param cir The callback info of the method and its returned float value
     * @see LivingEntity
     */
    @Inject(method="damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", at=@At("HEAD"), cancellable=true)
    private void mixin(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity)(Object)this;
        for (StatusEffectInstance instance : entity.getStatusEffects()) {
            if (instance.getEffectType().getClass().equals(NumbStatusEffect.class)) {
                try {
                    Field field = NumbStatusEffect.class.getDeclaredField("totalDamage");
                    field.setAccessible(true);
                    field.setFloat(instance.getEffectType(), field.getFloat(instance.getEffectType()) + amount);
                } catch (Exception e) {
                    //This should not occur
                    e.printStackTrace();
                }
                cir.cancel();
                return;
            }
        }
    }
}
