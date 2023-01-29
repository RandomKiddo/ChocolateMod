/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

/**
 * SoapFluid, abstract implementation of a flowable fluid in Fabric
 *
 * Overrides:
 * <code>
 *     matchesType, isInfinite, beforeBreakingBlock, canBeReplacedWith,
 *     getFlowSpeed, getLevelDecreasePerBlock, getTickRate, getBlastResistance,
 *     getStill, getFlowing, getBucketItem, toBlockState, appendProperties,
 *     getLevel, isStill
 * </code>
 *
 * Contains two subclasses representing the still and flowing versions of the abstract base class
 *
 * @see FlowableFluid
 */
public abstract class SoapFluid extends FlowableFluid {
    /**
     * Returns if this fluid matches the soap type
     * @param fluid The fluid to check
     * @return true if this fluid is of the same type
     */
    @Override public boolean matchesType(Fluid fluid) { return fluid == this.getStill() || fluid == this.getFlowing(); }

    /**
     * Checks if soap fluid implementation is infinite
     * @return false
     */
    @Override protected boolean isInfinite() { return false; }

    /**
     * Specifies what to do before breaking a block
     * @param world The world access
     * @param pos The block position
     * @param state The block state
     * @see WorldAccess
     */
    @Override protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    /**
     * Returns if this fluid can be replaced with the given arguments
     * @param state The given fluid state
     * @param view The block view
     * @param pos The block position
     * @param fluid The fluid instance
     * @param direction The direction
     * @return false
     */
    @Override protected boolean canBeReplacedWith(FluidState state, BlockView view, BlockPos pos, Fluid fluid, Direction direction) {
        return !state.isStill() && fluid.getClass().equals(WaterFluid.Still.class);
    }

    /**
     * Gets the flow speed of this fluid
     * @param view The world view
     * @return The value 4
     */
    @Override protected int getFlowSpeed(WorldView view) { return 4; }

    /**
     * Gets the level decrease per block
     * @param view The world view
     * @return The value 1
     */
    @Override protected int getLevelDecreasePerBlock(WorldView view) { return 1; }

    /**
     * Gets the tick rate for this fluid
     * @param view The world view
     * @return The value 5
     */
    @Override public int getTickRate(WorldView view) { return 5; }

    /**
     * Gets the blast resistance
     * @return Returns 100.0F
     */
    @Override protected float getBlastResistance() { return 100.0F; }

    /**
     * Gets the still version of this fluid
     * @return Fluid instance that's still
     */
    @Override public Fluid getStill() { return FluidRegistry.STILL_SOAP; }

    /**
     * Gets the flowing version of this fluid
     * @return Fluid instance that's flowing
     */
    @Override public Fluid getFlowing() { return FluidRegistry.FLOWING_SOAP; }

    /**
     * Gets the bucket item for this fluid
     * @return The Item instance of the fluid
     */
    @Override public Item getBucketItem() { return FluidRegistry.SOAP_BUCKET; }

    /**
     * Gets this fluid as a BlockState
     * @param fluidState The current fluid state
     * @return The block state equivalent for this fluid
     * @see BlockState
     */
    @Override protected BlockState toBlockState(FluidState fluidState) {
        return FluidRegistry.SOAP.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    /**
     * The subclass that represents the AcidFluid as flowing
     */
    public static class Flowing extends SoapFluid {
        /**
         * Appends properties to the flowing fluid
         * @param builder The fluid builder
         * @see StateManager.Builder
         */
        @Override protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        /**
         * Gets the current level of the flowing fluid
         * @param state The current fluid state instance
         * @return The current level
         */
        @Override public int getLevel(FluidState state) { return state.get(LEVEL); }

        /**
         * Checks if this fluid is still
         * @param state The current fluid state instance
         * @return false
         */
        @Override public boolean isStill(FluidState state) { return false; }
    }

    /**
     * The subclass that represents the AcidFluid as still
     */
    public static class Still extends SoapFluid {
        /**
         * Gets the current level of the still fluid
         * @param state The current fluid state instance
         * @return The value 8
         */
        @Override public int getLevel(FluidState state) { return 8; }

        /**
         * Checks if this fluid is still
         * @param state The current fluid state instance
         * @return true
         */
        @Override public boolean isStill(FluidState state) { return true; }
    }
}
