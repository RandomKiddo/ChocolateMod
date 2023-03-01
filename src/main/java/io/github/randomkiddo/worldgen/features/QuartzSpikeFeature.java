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

public class QuartzSpikeFeature extends Feature<QuartzSpikeFeatureConfig> {
    public QuartzSpikeFeature(Codec<QuartzSpikeFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override public boolean generate(FeatureContext<QuartzSpikeFeatureConfig> ctx) {
        StructureWorldAccess world = ctx.getWorld();
        BlockPos origin = ctx.getOrigin();
        QuartzSpikeFeatureConfig config = ctx.getConfig();
        int height = config.height();
        BlockState blockState = Blocks.SMOOTH_QUARTZ.getDefaultState();
        if (blockState == null) {
            throw new IllegalStateException();
        }
        BlockPos test = new BlockPos(origin);
        for (int y = 0; y < world.getHeight(); ++y) {
            test = test.up();
            if (world.getBlockState(test).isIn(BlockTags.BASE_STONE_NETHER) && world.getBlockState(test.up()).isOf(Blocks.AIR)) {
                int randHeight = (int)(Math.random() * height) + 3;
                //System.out.println(randHeight);
                for (int i = 0; i < randHeight; ++i) {
                    if (i % 2 == 0) {
                        for (int r = -1; r <= 1; ++r) {
                            for (int c = -1; c <=1; ++c) {
                                int rand = (int)(Math.random() * 2);
                                //System.out.println(rand);
                                if (rand != 0) {
                                    BlockPos pos = new BlockPos(test.getX() + r, test.getY(), test.getZ() + c);
                                    world.setBlockState(pos, blockState, 0x10);
                                }
                            }
                        }
                    } else {
                        world.setBlockState(test, blockState, 0x10);
                    }
                    test = test.up();
                    if (test.getY() >= world.getTopY()) { break; }
                }
                return true;
            }
        }
        return false;
    }
}
