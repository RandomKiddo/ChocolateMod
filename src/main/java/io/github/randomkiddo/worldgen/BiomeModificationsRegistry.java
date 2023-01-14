/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo
 */

package io.github.randomkiddo.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import static io.github.randomkiddo.fluids.FluidRegistry.ACID;

/**
 * Registers all vanilla biome modifications for this mod including: lakes
 */
@SuppressWarnings({ "deprecated" })
public class BiomeModificationsRegistry {
    /**
     * The acid lake configured feature, uses deprecated LakeFeature class
     * @see LakeFeature
     * @see LakeFeature.Config
     */
    @SuppressWarnings({ "deprecated" })
    public static final RegistryEntry<ConfiguredFeature<LakeFeature.Config, ?>> ACID_LAKE_CF = ConfiguredFeatures.register(
            "chocolate:acid_lake", Feature.LAKE,
            new LakeFeature.Config(BlockStateProvider.of(ACID.getDefaultState()), BlockStateProvider.of(ACID.getDefaultState())));
    /**
     * The placed feature for acid lakes
     */
    public static final RegistryEntry<PlacedFeature> ACID_LAKE_PF = PlacedFeatures.register(
            "chocolate:acid_lake", ACID_LAKE_CF, RarityFilterPlacementModifier.of(80),
            PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

    /**
     * Registers all related biome modification features above
     */
    public static void register() {
        BiomeModifications.create(new Identifier("chocolate", "acid_lake")).add(ModificationPhase.ADDITIONS, (biomeSelectionContext) ->
                biomeSelectionContext.hasTag(ConventionalBiomeTags.IN_THE_END), (biomeSelectionContext, biomeModificationContext) ->
                biomeModificationContext.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.LAKES, ACID_LAKE_PF.value())
        ); // Register and create acid lake
    }
}
