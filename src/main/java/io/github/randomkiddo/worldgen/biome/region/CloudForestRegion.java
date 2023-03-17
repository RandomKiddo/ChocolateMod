/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.biome.region;

import com.mojang.datafixers.util.Pair;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

import static io.github.randomkiddo.worldgen.biome.OverworldBiomes.CLOUD_FOREST_KEY;

/**
 * Creates a custom region that contains the cloud forest
 * @see Region
 */
public class CloudForestRegion extends Region {
    /**
     * Constructor for the cloud forest region
     * @param id The identifier
     * @param type The region type (dimension)
     * @param weight The percentage weight for the region
     */
    public CloudForestRegion(Identifier id, RegionType type, int weight) {
        super(id, type, weight);
    }

    /**
     * Adds the biomes to the region
     * @param registry The biome registry entry
     * @param mapper The mapping consumer
     */
    @Override public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(BiomeKeys.DESERT, CLOUD_FOREST_KEY);
            builder.replaceBiome(BiomeKeys.BADLANDS, CLOUD_FOREST_KEY);
            builder.replaceBiome(BiomeKeys.ERODED_BADLANDS, CLOUD_FOREST_KEY);
        });
    }
}
