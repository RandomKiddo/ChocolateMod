/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.biome;

import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static io.github.randomkiddo.worldgen.TreeRegistry.CLOUD_TREE_PLACED_FEATURE;

/**
 * Contains all methods and registry keys for custom biomes
 */
public class OverworldBiomes {
    /**
     * Cloud forest registry key
     */
    public static final RegistryKey<Biome> CLOUD_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("chocolate", "cloud_forest"));

    /**
     * The cloud forest biome
     * @return Biome instance of the cloud forest
     * @see Biome
     */
    public static Biome cloudForest() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addJungleMobs(spawnSettings);
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, CLOUD_TREE_PLACED_FEATURE);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);;
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addEmeraldOre(generationSettings);
        DefaultBiomeFeatures.addBamboo(generationSettings);
        DefaultBiomeFeatures.addJungleTrees(generationSettings);
        DefaultBiomeFeatures.addExtraDefaultFlowers(generationSettings);
        DefaultBiomeFeatures.addJungleGrass(generationSettings);
        DefaultBiomeFeatures.addKelp(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addMossyRocks(generationSettings);
        DefaultBiomeFeatures.addLushCavesDecoration(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addVines(generationSettings);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(.75f)
                .downfall(.95f)
                .effects((new BiomeEffects.Builder())
                        .waterColor(4052986)
                        .waterFogColor(4052986)
                        .fogColor(11971756)
                        .foliageColor(2469925)
                        .grassColor(1938973)
                        .skyColor(0x2cb6f6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build()
                )
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }
}
