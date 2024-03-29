/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.mixin;

import net.minecraft.client.render.entity.PigEntityRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * TechnoPigCrownMixin is a spongepowered mixin for Minecraft that changes all pig skins
 * to include a crown for the late Technoblade
 *
 * Injected into <code>getTexture</code> at <code>RETURN</code>
 * Cancellable (required)
 *
 * @see Mixin
 * @see Inject
 * @see At
 * @see PigEntityRenderer
 */
@Mixin(PigEntityRenderer.class)
public class TechnoPigCrownMixin {
    /**
     * Injects the specified code into getTexture
     * @param cir The callback info of the method and its returned Identifier instance
     * @see net.minecraft.entity.passive.PigEntity
     */
    @Inject(method="getTexture(Lnet/minecraft/entity/passive/PigEntity;)Lnet/minecraft/util/Identifier;", at=@At("RETURN"), cancellable = true)
    private void mixin(CallbackInfoReturnable<Identifier> cir) {
        cir.setReturnValue(new Identifier("chocolate", "textures/entity/pig/techno.png"));
    }
}
