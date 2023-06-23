/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.callbacks;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

import static io.github.randomkiddo.config.ConfigRegistry.ENABLE_LAG_REDUCTION;

/**
 * Registers all callback function
 */
public class CallbackRegistry {
    /**
     * Registers all callback functions below
     */
    public static void register() {
        if (ENABLE_LAG_REDUCTION) {
            UseBlockCallback.EVENT.register((player, world, hand, blockHitResult) -> {
                String name = hand.equals(Hand.MAIN_HAND) ? player.getMainHandStack().getName().toString() :
                        player.getOffHandStack().getName().toString();
                System.out.println(name);
                boolean check = name.contains("block.minecraft.sand") || name.contains("block.minecraft.red_sand");
                if (check) {
                    check = name.contains("block.minecraft.sand");
                    Block block = null;
                    if (check) {
                        block = Blocks.SAND;
                    } else {
                        block = Blocks.RED_SAND;
                    }
                    int y0 = blockHitResult.getBlockPos().getY();
                    int x = blockHitResult.getBlockPos().getX();
                    int z = blockHitResult.getBlockPos().getZ();
                    switch (blockHitResult.getSide()) {
                        case UP -> ++y0;
                        case DOWN -> --y0;
                        case EAST -> ++x;
                        case WEST -> --x;
                        case NORTH -> --z;
                        case SOUTH -> ++z;
                        default -> {
                        }
                    }
                    for (int y = y0; y > world.getBottomY(); --y) {
                        if (!world.getBlockState(new BlockPos(x, y, z)).getBlock().equals(Blocks.AIR)) {
                            world.setBlockState(new BlockPos(x, y + 1, z), block.getDefaultState());
                            return ActionResult.SUCCESS;
                        }
                    }
                    return ActionResult.PASS;
                }
                return ActionResult.PASS;
            });
        }
    }
}
