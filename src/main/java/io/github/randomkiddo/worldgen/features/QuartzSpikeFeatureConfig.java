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

public record QuartzSpikeFeatureConfig(int height) implements FeatureConfig {
    public QuartzSpikeFeatureConfig(int height) { this.height = height; }
    public static Codec<QuartzSpikeFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    Codecs.POSITIVE_INT.fieldOf("height").forGetter(QuartzSpikeFeatureConfig::height)
            ).apply(instance, QuartzSpikeFeatureConfig::new)
    );
    public int height() { return this.height; }
}
