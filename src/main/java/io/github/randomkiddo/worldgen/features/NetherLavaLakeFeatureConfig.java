/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.gen.feature.FeatureConfig;

public record NetherLavaLakeFeatureConfig(int depth, int width) implements FeatureConfig {
    public NetherLavaLakeFeatureConfig(int depth, int width) { this.depth = depth; this.width = width; }
    public static Codec<NetherLavaLakeFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    Codecs.POSITIVE_INT.fieldOf("depth").forGetter(NetherLavaLakeFeatureConfig::depth),
                    Codecs.POSITIVE_INT.fieldOf("width").forGetter(NetherLavaLakeFeatureConfig::width)
            ).apply(instance, NetherLavaLakeFeatureConfig::new)
    );
    public int depth() { return this.depth; }
    public int width() { return this.width; }
}
