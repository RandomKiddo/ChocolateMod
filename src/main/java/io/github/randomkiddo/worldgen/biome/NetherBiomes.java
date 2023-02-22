/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.NetherPlacedFeatures;

import static io.github.randomkiddo.worldgen.trees.TreeRegistry.SCORCHED_TREE_PLACED_FEATURE;
import static io.github.randomkiddo.worldgen.trees.TreeRegistry.TREE_STEMS_PLACED_FEATURE;

/**
 * Contains all methods and registry keys for custom nether biomes
 */
public class NetherBiomes {
    /**
     * Scorched forest registry key
     */
    public static final RegistryKey<Biome> SCORCHED_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("chocolate", "scorched_forest"));
    /**
     * The scorched forest biome
     * @return Biome instance of the scorched forest
     * @see Biome
     */
    public static Biome scorchedForest() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(
                EntityType.ZOMBIFIED_PIGLIN, 25, 1, 3
        ));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(
                EntityType.ZOGLIN, 10, 1, 2
        ));
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, SCORCHED_TREE_PLACED_FEATURE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.PATCH_FIRE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.PATCH_SOUL_FIRE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.GLOWSTONE);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.BLACKSTONE_BLOBS);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.SMALL_BASALT_COLUMNS);
        generationSettings.feature(GenerationStep.Feature.FLUID_SPRINGS, NetherPlacedFeatures.SPRING_DELTA);
        DefaultBiomeFeatures.addFrozenLavaSpring(generationSettings);
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
