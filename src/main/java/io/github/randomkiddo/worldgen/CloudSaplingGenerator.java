/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

/**
 * Gets the cloud tree feature and its sapling
 *
 * @see SaplingGenerator
 */
public class CloudSaplingGenerator extends SaplingGenerator {
    /**
     * Fetches the tree RegistryEntry feature
     * @param random A random
     * @param bees If bees will be present
     * @return The RegistryEntry representation of the tree
     * @see RegistryEntry
     * @see ConfiguredFeature
     * @see TreeFeatureConfig
     */
    @Nullable @Override protected RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> getTreeFeature(Random random, boolean bees) {
        return TreeRegistry.CLOUD_TREE;
    }
}
