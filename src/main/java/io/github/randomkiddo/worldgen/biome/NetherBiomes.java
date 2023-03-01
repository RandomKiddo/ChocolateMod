/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.RandomSplitter;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.NetherPlacedFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import static io.github.randomkiddo.worldgen.features.FeatureRegistry.*;

/**
 * Contains all methods and registry keys for custom nether biomes
 */
public class NetherBiomes {
    /**
     * Scorched forest registry key
     */
    public static final RegistryKey<Biome> QUARTZ_SPIKES_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("chocolate", "quartz_spikes"));
    /**
     * The blood biome
     * @return Biome instance of the blood
     * @see Biome
     */
    public static Biome quartzSpikes() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(
                EntityType.ZOGLIN, 1, 1, 1
        ));
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, RegistryEntry.of(QUARTZ_SPIKE_FEATURE_PLACED));
        generationSettings.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, RegistryEntry.of(QUARTZ_TREE_FEATURE_PLACED));
        generationSettings.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, RegistryEntry.of(NETHER_LAKE_FEATURE_PLACED));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.PATCH_FIRE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.PATCH_SOUL_FIRE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.GLOWSTONE);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        generationSettings.feature(GenerationStep.Feature.FLUID_SPRINGS, NetherPlacedFeatures.SPRING_DELTA);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(2f)
                .downfall(0f)
                .effects((new BiomeEffects.Builder())
                        .fogColor(3344392)
                        .skyColor(7254527)
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .build() //todo check
                )
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }
}
