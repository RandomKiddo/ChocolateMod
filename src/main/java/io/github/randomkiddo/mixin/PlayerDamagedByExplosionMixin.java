package io.github.randomkiddo.mixin;

import io.github.randomkiddo.effects.StatusEffectsRegistry;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerDamagedByExplosionMixin {
    @Inject(method="damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", at=@At("TAIL"))
    private void mixin(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source.isExplosive()) {
            PlayerEntity player = (PlayerEntity)(Object)this;
            if ((int)(Math.random() * 100 + 1) >= 10) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffectsRegistry.DAZED, (int)(Math.random() * 10 + 1) * 20, 0));
            }
        }
    }
}
