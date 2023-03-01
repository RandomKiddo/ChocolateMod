/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.trees;

import io.github.randomkiddo.Chocolate;
import io.github.randomkiddo.blocks.BlockRegistry;
import io.github.randomkiddo.mixin.CloudTrunkPlacerTypeInvoker;
import io.github.randomkiddo.worldgen.trees.CloudSaplingBlock;
import io.github.randomkiddo.worldgen.trees.CloudSaplingGenerator;
import io.github.randomkiddo.worldgen.trees.CloudTrunkPlacer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
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
     * The Pink Cherry Tree configured feature
     */
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> PINK_CHERRY_TREE = ConfiguredFeatures.register("chocolate:pink_cherry_tree", Feature.TREE,
            new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(BlockRegistry.PINK_CHERRY_LOGS),
                    new ForkingTrunkPlacer(6, 3, 0),
                    BlockStateProvider.of(BlockRegistry.PINK_CHERRY_LEAVES),
                    new AcaciaFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1)),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build()
    );
    /**
     * The pink cherry tree sapling
     */
    public static final PinkCherrySaplingBlock PINK_CHERRY_SAPLING = new PinkCherrySaplingBlock(
            new PinkCherrySaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
    /**
     * The check conditions for the pink cherry tree
     */
    public static final RegistryEntry<PlacedFeature> PINK_CHERRY_TREE_CHECKED = PlacedFeatures.register("chocolate:pink_cherry_tree_checked", PINK_CHERRY_TREE,
            List.of(PlacedFeatures.wouldSurvive(PINK_CHERRY_SAPLING)));
    /**
     * The spawn specifications of the pink cherry tree
     */
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> PINK_CHERRY_TREE_SPAWN = ConfiguredFeatures.register("chocolate:pink_cherry_tree_spawn", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfig(List.of(new RandomFeatureEntry(PINK_CHERRY_TREE_CHECKED, 0.7f)), PINK_CHERRY_TREE_CHECKED));
    /**
     * The cloud tree placed feature
     */
    public static final RegistryEntry<PlacedFeature> PINK_CHERRY_TREE_PLACED_FEATURE = PlacedFeatures.register("chocolate:pink_cherry_tree", PINK_CHERRY_TREE_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));
    /**
     * The White Cherry Tree configured feature
     */
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> WHITE_CHERRY_TREE = ConfiguredFeatures.register("chocolate:white_cherry_tree", Feature.TREE,
            new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(BlockRegistry.WHITE_CHERRY_LOGS),
                    new ForkingTrunkPlacer(4, 3, 0),
                    BlockStateProvider.of(BlockRegistry.WHITE_CHERRY_LEAVES),
                    new AcaciaFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1)),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build()
    );
    /**
     * The white cherry tree sapling
     */
    public static final WhiteCherrySaplingBlock WHITE_CHERRY_SAPLING = new WhiteCherrySaplingBlock(
            new WhiteCherrySaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
    /**
     * The check conditions for the white cherry tree
     */
    public static final RegistryEntry<PlacedFeature> WHITE_CHERRY_TREE_CHECKED = PlacedFeatures.register("chocolate:white_cherry_tree_checked", WHITE_CHERRY_TREE,
            List.of(PlacedFeatures.wouldSurvive(WHITE_CHERRY_SAPLING)));
    /**
     * The spawn specifications of the white cherry tree
     */
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> WHITE_CHERRY_TREE_SPAWN = ConfiguredFeatures.register("chocolate:white_cherry_tree_spawn", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfig(List.of(new RandomFeatureEntry(WHITE_CHERRY_TREE_CHECKED, 0.7f)), WHITE_CHERRY_TREE_CHECKED));
    /**
     * The white cherry tree placed feature
     */
    public static final RegistryEntry<PlacedFeature> WHITE_CHERRY_TREE_PLACED_FEATURE = PlacedFeatures.register("chocolate:white_cherry_tree", WHITE_CHERRY_TREE_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));
    /**
     * The tree stems configured feature
     */
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> TREE_STEMS = ConfiguredFeatures.register("chocolate:tree_stems", Feature.TREE,
            new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(Blocks.OAK_LOG),
                    new ForkingTrunkPlacer(4, 3, 0),
                    BlockStateProvider.of(Blocks.AIR),
                    new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 1),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build()
    );
    /**
     * The check conditions for the white cherry tree
     */
    public static final RegistryEntry<PlacedFeature> TREE_STEMS_CHECKED = PlacedFeatures.register("chocolate:tree_stems_checked", TREE_STEMS,
            List.of(PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING)));
    /**
     * The spawn specifications of the white cherry tree
     */
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> TREE_STEMS_SPAWN = ConfiguredFeatures.register("chocolate:tree_stems_spawn", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfig(List.of(new RandomFeatureEntry(TREE_STEMS_CHECKED, 0.7f)), TREE_STEMS_CHECKED));
    /**
     * The white cherry tree placed feature
     */
    public static final RegistryEntry<PlacedFeature> TREE_STEMS_PLACED_FEATURE = PlacedFeatures.register("chocolate:tree_stems", TREE_STEMS_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));
    /**
     * Registers all the un-registered fields above
     */
    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "cloud_sapling"), CLOUD_SAPLING);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "cloud_sapling"), new BlockItem(
                CLOUD_SAPLING, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP)
        ));
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "pink_cherry_sapling"), PINK_CHERRY_SAPLING);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "pink_cherry_sapling"), new BlockItem(
                PINK_CHERRY_SAPLING, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP)
        ));
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "white_cherry_sapling"), WHITE_CHERRY_SAPLING);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "white_cherry_sapling"), new BlockItem(
                WHITE_CHERRY_SAPLING, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP)
        ));
    }
}
