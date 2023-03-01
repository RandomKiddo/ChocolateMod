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
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.worldgen.DefaultNetherRegion;

import java.util.function.Consumer;

import static io.github.randomkiddo.worldgen.biome.NetherBiomes.QUARTZ_SPIKES_KEY;

/**
 * Creates a custom region that contains the blood biome
 * @see Region
 */
public class QuartzSpikesRegion extends DefaultNetherRegion {
    /**
     * Constructor for the blood region
     * @param weight The percentage weight for the region
     */
    public QuartzSpikesRegion(int weight) {
        super(weight);
    }

    /**
     * Adds the biomes to the region
     * @param registry The biome registry entry
     * @param mapper The mapping consumer
     */
    @Override public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        super.addBiomes(registry, mapper);
        this.addBiome(mapper, MultiNoiseUtil.ParameterRange.of(0.0F), MultiNoiseUtil.ParameterRange.of(0.0F), MultiNoiseUtil.ParameterRange.of(0.0F),
                MultiNoiseUtil.ParameterRange.of(0.0F), MultiNoiseUtil.ParameterRange.of(0.0F), MultiNoiseUtil.ParameterRange.of(0.0F), 0.0F, QUARTZ_SPIKES_KEY);
    }
}
