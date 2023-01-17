/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen;

import io.github.randomkiddo.Chocolate;
import io.github.randomkiddo.blocks.BlockRegistry;
import io.github.randomkiddo.mixin.CloudTrunkPlacerTypeInvoker;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;

/**
 * Registers all trees and related features for this mod
 */
public class TreeRegistry {
    /**
     * The Cloud Tree configured feature
     */
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CLOUD_TREE = ConfiguredFeatures.register("chocolate:cloud_tree", Feature.TREE,
            new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(BlockRegistry.CLOUD_LOGS),
                    new CloudTrunkPlacer(8, 3, 0),
                    BlockStateProvider.of(BlockRegistry.CLOUD_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).decorators(List.of(new LeavesVineTreeDecorator(0.5f), TrunkVineTreeDecorator.INSTANCE)).build()
    );
    /**
     * The cloud tree sapling
     */
    public static final CloudSaplingBlock CLOUD_SAPLING = new CloudSaplingBlock(
            new CloudSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
    /**
     * The check conditions for the cloud tree
     */
    public static final RegistryEntry<PlacedFeature> CLOUD_TREE_CHECKED = PlacedFeatures.register("chocolate:cloud_tree_checked", CLOUD_TREE,
            List.of(PlacedFeatures.wouldSurvive(CLOUD_SAPLING)));
    /**
     * The spawn specifications of the cloud tree
     */
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CLOUD_TREE_SPAWN = ConfiguredFeatures.register("chocolate:cloud_tree_spawn", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfig(List.of(new RandomFeatureEntry(CLOUD_TREE_CHECKED, 0.7f)), CLOUD_TREE_CHECKED));
    /**
     * The cloud tree placed feature
     */
    public static final RegistryEntry<PlacedFeature> CLOUD_TREE_PLACED_FEATURE = PlacedFeatures.register("chocolate:cloud_tree", CLOUD_TREE_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));
    /**
     * The cloud trunk placer
     */
    public static final TrunkPlacerType<CloudTrunkPlacer> CLOUD_TRUNK_PLACER = CloudTrunkPlacerTypeInvoker.callRegister("chocolate:cloud_trunk_placer", CloudTrunkPlacer.CODEC);

    /**
     * Registers all the un-registered fields above
     */
    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "cloud_sapling"), CLOUD_SAPLING);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "cloud_sapling"), new BlockItem(
                CLOUD_SAPLING, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP)
        ));
    }
}
