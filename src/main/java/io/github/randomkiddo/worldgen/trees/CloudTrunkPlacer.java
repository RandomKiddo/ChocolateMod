/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.trees;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Specifies how to place the trunk of the cloud tree
 *
 * @see TrunkPlacer
 */
public class CloudTrunkPlacer extends TrunkPlacer {
    /**
     * The Mojang Codec for the trunk placer
     */
    public static final Codec<CloudTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillTrunkPlacerFields(instance).apply(instance, CloudTrunkPlacer::new));

    /**
     * Instantiates a new CloudTrunkPlacer
     * @param baseHeight The base height to use
     * @param frh The first random height
     * @param srh The second random height
     */
    public CloudTrunkPlacer(int baseHeight, int frh, int srh) { super(baseHeight, frh, srh); }

    /**
     * Gets the trunk placer type
     * @return The TrunkPlacerType instance
     * @see TrunkPlacerType
     */
    @Override protected TrunkPlacerType<?> getType() { return TreeRegistry.CLOUD_TRUNK_PLACER; }

    /**
     * Generates the tree trunk
     * @param world The testable world
     * @param replacer The bi-consumer replacer
     * @param random A random
     * @param height The height
     * @param startPos The starting position
     * @param config The tree configuration feature
     * @return List of TreeNodes to connect
     * @see net.minecraft.world.gen.foliage.FoliagePlacer.TreeNode
     * @see FoliagePlacer
     */
    @Override public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                                           Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);
        for (int i = 0; i < height; ++i) {
            this.getAndSetState(world, replacer, random, startPos.up(i), config);
            this.getAndSetState(world, replacer, random, startPos.up(i).east().north(), config);
        }
        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, false),
                new FoliagePlacer.TreeNode(startPos.east().north().up(height), 0, false));
    }
}
