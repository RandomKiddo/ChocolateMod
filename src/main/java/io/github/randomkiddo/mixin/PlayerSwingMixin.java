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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * PlayerSwingMixin is a spongepowered mixin for Minecraft that checks when the user swings
 *
 * Injected into <code>attack</code> at <code>HEAD</code>
 * Cancellable (required)
 *
 * @see Mixin
 * @see Inject
 * @see At
 * @see PlayerEntity
 */
@Mixin(PlayerEntity.class)
public class PlayerSwingMixin {
    @Inject(method="attack(Lnet/minecraft/entity/Entity;)V", at=@At("HEAD"))
    private void mixin(Entity entity, CallbackInfo ci) {
        PlayerEntity pe = (PlayerEntity)(Object)this;
        CopperSwordItem csi = null;
        try {
            csi = (CopperSwordItem)(pe.getMainHandStack().getItem());
        } catch(ClassCastException ccerr) {
            /* do nothing */
        }
        if (csi != null && csi.isCharged() && csi.swingsLeft > 0 && csi.canSwing()) {
            --csi.swingsLeft;
            LightningEntity le = new LightningEntity(EntityType.LIGHTNING_BOLT, pe.getWorld());
            le.setPosition(entity.getPos());
            pe.getWorld().spawnEntity(le);
            if (csi.swingsLeft == 0) { csi.setCharged(false); csi.swingsLeft = 5; }
            csi.lastSwing = System.currentTimeMillis();
        }
    }
}
