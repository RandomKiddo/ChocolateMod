/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.features;

import com.mojang.serialization.Codec;
import io.github.randomkiddo.blocks.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

/**
 * Quartz Tree Feature (generation behavior)
 */
public class QuartzTreeFeature extends Feature<QuartzTreeFeatureConfig> {
    /**
     * Default constructor
     * @param configCodec The custom codec
     */
    public QuartzTreeFeature(Codec<QuartzTreeFeatureConfig> configCodec) {
        super(configCodec);
    }
    /**
     * Generates the feature
     * @param ctx The feature context
     * @return A boolean representing success or failure
     */
    @Override public boolean generate(FeatureContext<QuartzTreeFeatureConfig> ctx) {
        StructureWorldAccess world = ctx.getWorld();
        BlockPos origin = ctx.getOrigin();
        QuartzTreeFeatureConfig config = ctx.getConfig();
        int dense = config.dense();
        final int[] heights = {5, 7, 9};
        BlockState blockState = BlockRegistry.QUARTZ_STEM.getDefaultState();
        if (dense == 0) {
            BlockPos test = new BlockPos(origin);
            for (int y = 0; y < world.getHeight(); ++y) {
                test = test.up();
                if (world.getBlockState(test).isIn(BlockTags.BASE_STONE_NETHER) && world.getBlockState(test.up()).isOf(Blocks.AIR)) {
                    int randHeight = heights[(int)(Math.random() * 3)];
                    for (int i = 1; i <= randHeight; ++i) {
                        if (i == 3) {
                            world.setBlockState(test, blockState, 0x10);
                            BlockPos pos = new BlockPos(test.getX() + 1, test.getY(), test.getZ());
                            world.setBlockState(pos, blockState, 0x10);
                            pos = new BlockPos(test.getX() - 1, test.getY(), test.getZ());
                            world.setBlockState(pos, blockState, 0x10);
                            pos = new BlockPos(test.getX(), test.getY(), test.getZ() + 1);
                            world.setBlockState(pos, blockState, 0x10);
                            pos = new BlockPos(test.getX(), test.getY(), test.getZ() - 1);
                            world.setBlockState(pos, blockState, 0x10);
                        } else if (i == 4 || i == 5) {
                            world.setBlockState(test, blockState, 0x10);
                            BlockPos pos = new BlockPos(test.getX() + 2, test.getY(), test.getZ());
                            world.setBlockState(pos, blockState, 0x10);
                            pos = new BlockPos(test.getX() - 2, test.getY(), test.getZ());
                            world.setBlockState(pos, blockState, 0x10);
                            pos = new BlockPos(test.getX(), test.getY(), test.getZ() + 2);
                            world.setBlockState(pos, blockState, 0x10);
                            pos = new BlockPos(test.getX(), test.getY(), test.getZ() - 2);
                            world.setBlockState(pos, blockState, 0x10);
                        } else if (i == 6 || i == 7 || i == 8) {
                            world.setBlockState(test, blockState, 0x10);
                            BlockPos pos = new BlockPos(test.getX() + 3, test.getY(), test.getZ());
                            world.setBlockState(pos, blockState, 0x10);
                            pos = new BlockPos(test.getX() - 3, test.getY(), test.getZ());
                            world.setBlockState(pos, blockState, 0x10);
                            pos = new BlockPos(test.getX(), test.getY(), test.getZ() + 3);
                            world.setBlockState(pos, blockState, 0x10);
                            pos = new BlockPos(test.getX(), test.getY(), test.getZ() - 3);
                            world.setBlockState(pos, blockState, 0x10);
                        } else {
                            world.setBlockState(test, blockState, 0x10);
                        }
                        test = test.up();
                        if (test.getY() >= world.getTopY()) { break; }
                    }
                    return true;
                }
            }
        } else {
            BlockPos test = new BlockPos(origin);
            /* no behavior yet */ //todo
        }
        return false;
    }
}
