/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.ores;

import io.github.randomkiddo.blocks.BlockRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.util.Identifier;

import java.util.Arrays;

/**
 * Registers all ores for this mod
 */
public class OreRegistry {
    /**
     * Configured feature for Foselium
     * @see ConfiguredFeature
     */
    private static ConfiguredFeature<?, ?> FOSELIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
            Feature.ORE, new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    BlockRegistry.FOSELIUM_ORE.getDefaultState(), 5
    ));
    /**
     * Placed feature for Foselium
     * @see PlacedFeature
     */
    public static PlacedFeature FOSELIUM_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(FOSELIUM_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(2),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
            )
    );

    /**
     * Configured feature for Etherium
     * @see ConfiguredFeature
     * -Future edits to be made on BlockMatchRuleTest
     */
    private static ConfiguredFeature<?, ?> ETHERIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
            Feature.ORE, new OreFeatureConfig(
            new BlockMatchRuleTest(Blocks.STONE),
            BlockRegistry.ETHERIUM_ORE.getDefaultState(), 9
    ));
    /**
     * Placed feature for Etherium
     * @see PlacedFeature
     * -Future edits to be made on lines 78 - 80
     */
    public static PlacedFeature ETHERIUM_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(ETHERIUM_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(2),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
            )
    );
    /**
     * Registers all the ore features above
     * @see Registry
     */
    public static void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("chocolate", "foselium_ore"), FOSELIUM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE,
                new Identifier("chocolate", "foselium_ore"), FOSELIUM_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("chocolate", "foselium_ore")));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("chocolate", "etherium_ore"), ETHERIUM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE,
                new Identifier("chocolate", "etherium_ore"), ETHERIUM_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("chocolate", "etherium_ore")));
    }
}
