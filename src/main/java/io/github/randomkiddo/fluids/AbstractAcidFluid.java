/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.fluids;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class AbstractAcidFluid extends FlowableFluid {
    @Override public boolean matchesType(Fluid fluid) { return fluid == getStill() || fluid == getFlowing(); }
    @Override protected boolean isInfinite() { return false; }
    @Override protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        if (!world.isClient()) {
            world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH,
                    SoundCategory.BLOCKS, .5f, 2f);
        }
    }
    @Override protected boolean canBeReplacedWith(FluidState state, BlockView view, BlockPos pos,
                                                  Fluid fluid, Direction direction) {
        return false;
    }
    @Override protected int getFlowSpeed(WorldView view) { return 6; }
    @Override protected int getLevelDecreasePerBlock(WorldView view) { return 1; }
    @Override public int getTickRate(WorldView view) { return 5; }
    @Override protected float getBlastResistance() { return 100.0F; }
    @Override public Fluid getFlowing() { return null; } //todo bucket, flowing, still
    @Override public Fluid getStill() { return null; }
    @Override public Item getBucketItem() { return null; }
    @Override protected BlockState toBlockState(FluidState state) { return null; } //todo block state
}
