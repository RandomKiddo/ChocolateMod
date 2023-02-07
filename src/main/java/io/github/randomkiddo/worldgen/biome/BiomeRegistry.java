/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.biome;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;

import static io.github.randomkiddo.worldgen.biome.OverworldBiomes.CHERRY_BLOSSOM_FOREST_KEY;
import static io.github.randomkiddo.worldgen.biome.OverworldBiomes.CLOUD_FOREST_KEY;

/**
 * Registers all biomes for the mod
 */
public class BiomeRegistry {
    /**
     * Physically registers the custom biomes
     */
    public static void register() {
        Registry.register(BuiltinRegistries.BIOME, CLOUD_FOREST_KEY, OverworldBiomes.cloudForest());
        Registry.register(BuiltinRegistries.BIOME, CHERRY_BLOSSOM_FOREST_KEY, OverworldBiomes.cherryBlossomForest());
    }
}
