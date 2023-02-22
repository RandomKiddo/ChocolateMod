/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * PlayerFallDamageMixin is a spongepowered mixin for Minecraft that checks when the player
 * loses hunger, and runs specified code
 *
 * Injected into <code>update</code> at <code>TAIL</code>
 *
 * @see Mixin
 * @see Inject
 * @see At
 * @see HungerManager
 */
@Mixin(HungerManager.class)
public class PlayerHungerDropsMixin {
    /**
     * Injects the specified code into update
     * @param player The player entity
     * @param ci The callback info of the method
     * @see PlayerEntity
     */
    @Inject(method="update(Lnet/minecraft/entity/player/PlayerEntity;)V", at=@At("TAIL"))
    private void mixin(PlayerEntity player, CallbackInfo ci) {
        HungerManager manager = (HungerManager)(Object)this;
        final EquipmentSlot[] slots = { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET };
        if (manager.isNotFull() && manager.getFoodLevel() < manager.getPrevFoodLevel()) {
            while (manager.isNotFull()) {
                AtomicInteger slot = new AtomicInteger();
                player.getArmorItems().forEach(item -> {
                    if (item.toString().contains("chocolate_")) {
                        manager.add(4, 1.0f);
                        item.damage(2, player, (p) -> {
                            p.sendEquipmentBreakStatus(slots[slot.get()]);
                        });
                    }
                    slot.incrementAndGet();
                });
                player.getWorld().playSound(player, player.getBlockPos(), SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 1f, 1f);
            }
        }
    }
}
