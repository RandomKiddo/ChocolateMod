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
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

/**
 * Nether Lava Lake Feature (generation behavior)
 */
public class NetherLavaLakeFeature extends Feature<NetherLavaLakeFeatureConfig> {
    /**
     * Default constructor
     * @param configCodec The custom codec
     */
    public NetherLavaLakeFeature(Codec<NetherLavaLakeFeatureConfig> configCodec) { super(configCodec); }

    /**
     * Generates the feature
     * @param ctx The feature context
     * @return A boolean representing success or failure
     */
    @Override public boolean generate(FeatureContext<NetherLavaLakeFeatureConfig> ctx) {
        StructureWorldAccess world = ctx.getWorld();
        BlockPos origin = ctx.getOrigin();
        NetherLavaLakeFeatureConfig config = ctx.getConfig();
        int depth = config.depth();
        int width = config.width();
        final BlockState blockState = Blocks.LAVA.getDefaultState();
        BlockPos test = new BlockPos(origin);
        for (int y = 0; y < world.getHeight(); ++y) {
            test = test.up();
            if (world.getBlockState(test).isIn(BlockTags.BASE_STONE_NETHER) && world.getBlockState(test.up()).isOf(Blocks.AIR)) {
                for (int r = 0; r < width; ++r) {
                    for (int c = 0; c < width; ++c) {
                        BlockPos pos = new BlockPos(test.getX() + r, test.getY(), test.getZ() + c);
                        if (world.getBlockState(pos.up()).isOf(Blocks.AIR)) {
                            for (int y0 = 0; y0 < depth; ++y0) {
                                pos = new BlockPos(pos.getX(), pos.getY()-y0, pos.getZ());
                                world.setBlockState(pos, blockState, 0x10);
                            }
                        }
                    }
                }
                for (int c = -1; c < width + 1; ++c) {
                    BlockPos pos1 = new BlockPos(test.getX()+c, test.getY(), test.getZ()-1);
                    BlockPos pos2 = new BlockPos(test.getX()+c, test.getY(), test.getZ()+width);
                    int rand1 = (int)(Math.random() * 2);
                    int rand2 = (int)(Math.random() * 2);
                    if (rand1 == 1) {
                        world.setBlockState(pos1, blockState, 0x10);
                    } else if (rand2 == 1) {
                        world.setBlockState(pos2, blockState, 0x10);
                    }
                }
                for (int r = -1; r < width + 1; ++r) {
                    BlockPos pos1 = new BlockPos(test.getX()-1, test.getY(), test.getZ()+r);
                    BlockPos pos2 = new BlockPos(test.getX()+width, test.getY(), test.getZ()+r);
                    int rand1 = (int)(Math.random() * 2);
                    int rand2 = (int)(Math.random() * 2);
                    if (rand1 == 1) {
                        world.setBlockState(pos1, blockState, 0x10);
                    } else if (rand2 == 1) {
                        world.setBlockState(pos2, blockState, 0x10);
                    }
                }
                return true;
            }
            test = test.up();
            if (test.getY() >= world.getTopY()) { break; }
        }
        return false;
    }
}
