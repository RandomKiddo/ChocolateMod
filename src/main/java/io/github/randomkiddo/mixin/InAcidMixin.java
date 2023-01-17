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
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * InAcidMixin is a spongepowered mixin for Minecraft that detects if an entity is in acid, and if so,
 * the entity is set to take damage
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
public class InAcidMixin {
    /**
     * Injects the specified code into isTouchingWater
     * @param cir The callback info of the method and its returned boolean value
     * @see Entity
     */
    @Inject(method="isTouchingWater()Z", at=@At("RETURN"), cancellable = false)
    private void mixin(CallbackInfoReturnable<Boolean> cir) {
        Entity entity = (Entity)(Object)this;
        String name = entity.getBlockStateAtPos().getBlock().getName().toString();
        if (cir.getReturnValue() && name.contains("block.chocolate.acid")) {
            entity.damage(DamageSource.LAVA, 15.0f);
        }
    }
}
