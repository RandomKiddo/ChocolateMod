/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.callback;

import io.github.randomkiddo.tools.CopperPickaxeItem;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.util.ActionResult;

public class CallbackRegistry {
    public static void register() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            CopperPickaxeItem cpi = null;
            try {
                cpi = (CopperPickaxeItem)(player.getMainHandStack().getItem());
            } catch (ClassCastException ccerr) {
                return ActionResult.PASS;
            }
            if (cpi == null) { return ActionResult.PASS; }
            else if (cpi.isCharged() && cpi.swingsLeft > 0) {
                --cpi.swingsLeft;

            }
            return ActionResult.SUCCESS;
        });
    }
}
