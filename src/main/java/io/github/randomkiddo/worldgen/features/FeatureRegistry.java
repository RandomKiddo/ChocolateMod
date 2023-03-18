/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.features;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

/**
 * Registers all features for this mod
 */
public class FeatureRegistry {
    /**
     * Feature id for quartz spikes
     */
    public static final Identifier QUARTZ_SPIKE_FEATURE_ID = new Identifier("chocolate", "quartz_spike_feature");
    /**
     * Quartz spike feature
     */
    public static Feature<QuartzSpikeFeatureConfig> QUARTZ_SPIKE_FEATURE = new QuartzSpikeFeature(QuartzSpikeFeatureConfig.CODEC);
    /**
     * Quartz spike configured feature
     */
    public static ConfiguredFeature<QuartzSpikeFeatureConfig, QuartzSpikeFeature> QUARTZ_SPIKE_FEATURE_CONFIGURED = new ConfiguredFeature<>(
            (QuartzSpikeFeature)QUARTZ_SPIKE_FEATURE,
            new QuartzSpikeFeatureConfig(7)
    );
    /**
     * Quartz spike placed feature
     */
    public static PlacedFeature QUARTZ_SPIKE_FEATURE_PLACED = new PlacedFeature(
            RegistryEntry.of(QUARTZ_SPIKE_FEATURE_CONFIGURED), List.of(SquarePlacementModifier.of())
    );
    /**
     * Quartz tree feature id
     */
    public static final Identifier QUARTZ_TREE_FEATURE_ID = new Identifier("chocolate", "quartz_tree_feature");
    /**
     * Quartz tree feature
     */
    public static Feature<QuartzTreeFeatureConfig> QUARTZ_TREE_FEATURE = new QuartzTreeFeature(QuartzTreeFeatureConfig.CODEC);
    /**
     * Quartz tree feature configured
     */
    public static ConfiguredFeature<QuartzTreeFeatureConfig, QuartzTreeFeature> QUARTZ_TREE_FEATURE_CONFIGURED = new ConfiguredFeature<>(
            (QuartzTreeFeature)QUARTZ_TREE_FEATURE,
            new QuartzTreeFeatureConfig(0)
    );
    /**
     * Quartz tree placed feature
     */
    public static PlacedFeature QUARTZ_TREE_FEATURE_PLACED = new PlacedFeature(
            RegistryEntry.of(QUARTZ_TREE_FEATURE_CONFIGURED), List.of(SquarePlacementModifier.of())
    );
    /**
     * Nether lake feature id
     */
    public static final Identifier NETHER_LAKE_FEATURE_ID = new Identifier("chocolate", "nether_lake_feature");
    /**
     * Nether lake feature
     */
    public static Feature<NetherLavaLakeFeatureConfig> NETHER_LAKE_FEATURE = new NetherLavaLakeFeature(NetherLavaLakeFeatureConfig.CODEC);
    /**
     * Nether lake configured feature
     */
    public static ConfiguredFeature<NetherLavaLakeFeatureConfig, NetherLavaLakeFeature> NETHER_LAKE_FEATURE_CONFIGURED = new ConfiguredFeature<>(
            (NetherLavaLakeFeature)NETHER_LAKE_FEATURE,
            new NetherLavaLakeFeatureConfig(3, 5)
    );
    /**
     * Nether lake placed feature
     */
    public static PlacedFeature NETHER_LAKE_FEATURE_PLACED = new PlacedFeature(
            RegistryEntry.of(NETHER_LAKE_FEATURE_CONFIGURED), List.of(SquarePlacementModifier.of())
    );
    /**
     * Registers all the features above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.FEATURE, QUARTZ_SPIKE_FEATURE_ID, QUARTZ_SPIKE_FEATURE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, QUARTZ_SPIKE_FEATURE_ID, QUARTZ_SPIKE_FEATURE_CONFIGURED);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, QUARTZ_SPIKE_FEATURE_ID, QUARTZ_SPIKE_FEATURE_PLACED);
        Registry.register(Registry.FEATURE, QUARTZ_TREE_FEATURE_ID, QUARTZ_TREE_FEATURE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, QUARTZ_TREE_FEATURE_ID, QUARTZ_TREE_FEATURE_CONFIGURED);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, QUARTZ_TREE_FEATURE_ID, QUARTZ_TREE_FEATURE_PLACED);
        Registry.register(Registry.FEATURE, NETHER_LAKE_FEATURE_ID, NETHER_LAKE_FEATURE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, NETHER_LAKE_FEATURE_ID, NETHER_LAKE_FEATURE_CONFIGURED);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, NETHER_LAKE_FEATURE_ID, NETHER_LAKE_FEATURE_PLACED);
    }
}
