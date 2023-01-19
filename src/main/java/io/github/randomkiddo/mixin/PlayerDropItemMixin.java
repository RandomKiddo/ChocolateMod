/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * InAcidMixin is a spongepowered mixin for Minecraft that detects if a player is dropping an item
 *
 * Injected into <code>isTouchingWater</code> at <code>RETURN</code>
 * Non-cancellable
 *
 * @see Mixin
 * @see Inject
 * @see At
 * @see PlayerEntity
 */
@Mixin(PlayerEntity.class)
public class PlayerDropItemMixin {
    @Inject(method="dropItem(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/ItemEntity;", at=@At("TAIL"))
    private void mixin(ItemStack item, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir) {
        if (item.getName().toString().contains("item.chocolate.soap") && !item.getName().toString().contains("soap_bucket")
        && cir.getReturnValue().isSubmergedInWater()) {
            World world = cir.getReturnValue().getWorld();
        }
    }
    @Inject(method="dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", at=@At("TAIL"))
    private void mixin2(ItemStack item, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir) {
        System.out.println(item.getName().toString());
    }
}
