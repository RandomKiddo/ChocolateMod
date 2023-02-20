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
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.NetherPlacedFeatures;

import static io.github.randomkiddo.worldgen.trees.TreeRegistry.*;

/**
 * Contains all methods and registry keys for custom overworld biomes
 */
public class OverworldBiomes {
    /**
     * Cloud forest registry key
     */
    public static final RegistryKey<Biome> CLOUD_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("chocolate", "cloud_forest"));
    /**
     * Cherry blossom forest registry key
     */
    public static final RegistryKey<Biome> CHERRY_BLOSSOM_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("chocolate", "cherry_blossom_forest"));
    /**
     * Cherry blossom forest registry key
     */
    public static final RegistryKey<Biome> NETHER_REACTOR_LEFTOVER_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("chocolate", "nether_reactor_leftover"));
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

    /**
     * The cherry blossom forest biome
     * @return Biome instance of the cherry blossom forest
     * @see Biome
     */
    public static Biome cherryBlossomForest() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, PINK_CHERRY_TREE_PLACED_FEATURE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, WHITE_CHERRY_TREE_PLACED_FEATURE);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);;
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addForestFlowers(generationSettings);
        DefaultBiomeFeatures.addForestGrass(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.SNOW)
                .temperature(.6f)
                .downfall(.01f)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x274db4)
                        .waterFogColor(0x274db4)
                        .fogColor(0xfec9ff)
                        .foliageColor(0x257103)
                        .grassColor(0x257103)
                        .skyColor(0x73aeff)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build()
                )
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }
    /**
     * The nether reactor leftover biome
     * @return Biome instance of the nether reactor leftover
     * @see Biome
     */
    public static Biome netherReactorLeftover() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(
                EntityType.ZOMBIFIED_PIGLIN, 10, 1, 2
        ));
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        DefaultBiomeFeatures.addNetherMineables(generationSettings);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, TREE_STEMS_PLACED_FEATURE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.PATCH_FIRE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.PATCH_SOUL_FIRE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.GLOWSTONE);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.BLACKSTONE_BLOBS);
        generationSettings.feature(GenerationStep.Feature.FLUID_SPRINGS, NetherPlacedFeatures.SPRING_CLOSED);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1f)
                .downfall(0f)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xff3a3a)
                        .waterFogColor(0xff3a3a)
                        .skyColor(0xff0f0f)
                        .fogColor(0xcc0000) //todo trees with just stems in this biome
                        .foliageColor(0xbc0303)
                        .grassColor(0xbc0303)
                        .build()
                )
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }
}
