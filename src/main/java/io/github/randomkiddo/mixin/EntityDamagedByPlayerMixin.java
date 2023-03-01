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
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class EntityDamagedByPlayerMixin {
    @Inject(method="attack(Lnet/minecraft/entity/Entity;)V", at=@At("HEAD"), cancellable = true)
    private void mixin(Entity entity, CallbackInfo ci) {
        if (entity instanceof PigEntity) {
            PlayerEntity player = (PlayerEntity)(Object)this;
            player.sendMessage(Text.of("Technoblade never dies!"));
            player.kill();
            ci.cancel();
            assert ci.isCancelled();
        }
    }
}
