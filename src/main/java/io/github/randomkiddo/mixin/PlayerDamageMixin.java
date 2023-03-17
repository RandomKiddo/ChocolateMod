/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.mixin;

import io.github.randomkiddo.tools.CopperSwordItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * PlayerFallDamageMixin is a spongepowered mixin for Minecraft that checks when the user takes damage
 * and handles if damage should be taken
 *
 * Injected into <code>damage</code> at <code>HEAD</code>
 * Cancellable (required)
 *
 * @see Mixin
 * @see Inject
 * @see At
 * @see PlayerEntity
 */
@Mixin(PlayerEntity.class)
public class PlayerDamageMixin {
    /**
     * Injects the specified code into damage method
     * @param source The damage source
     * @param amount The damage amount
     * @param cir The callback info of the method and its returned float value
     * @see PlayerEntity
     */
    @Inject(method="damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", at=@At("HEAD"), cancellable=true)
    private void mixin(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity)(Object)this;
        if (source.isFromFalling()) {
            player.getArmorItems().forEach((item) -> {
                if (item.toString().contains("slime_boots")) {
                    Vec3d vNought = player.getVelocity();
                    player.setVelocity(vNought.getX(), vNought.getY()*-1, vNought.getZ());
                    player.velocityModified = true;
                    item.damage((int)Math.ceil(-1*vNought.getY()), player, (p) -> {
                        p.sendEquipmentBreakStatus(EquipmentSlot.FEET);
                    });
                    cir.cancel();
                }
            });
        } else if (source.equals(DamageSource.LIGHTNING_BOLT)) {
            int copperSlots = 0;
            for (ItemStack item : player.getArmorItems()) {
                if (item.toString().toLowerCase().contains("copper")) { ++copperSlots; }
            }
            if (copperSlots == 0) { return; }
            else if (copperSlots == 4) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 15 * 20));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 15 * 20, 2));
                final EquipmentSlot[] slots = {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
                AtomicInteger slot = new AtomicInteger();
                for (ItemStack item : player.getArmorItems()) {
                    item.damage(5, player, p -> {
                        p.sendEquipmentBreakStatus(slots[slot.get()]);
                        slot.incrementAndGet();
                    });
                }
                cir.cancel();
            } else {
                player.damage(DamageSource.GENERIC, amount-copperSlots);
                cir.cancel();
            }
            if (player.getInventory().getMainHandStack().toString().contains("copper_sword")) {
                ((CopperSwordItem)(player.getInventory().getMainHandStack().getItem())).setCharged(true);
            }
        }
    }
}
