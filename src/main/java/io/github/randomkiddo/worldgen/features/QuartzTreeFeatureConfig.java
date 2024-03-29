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

/**
 * Quartz Tree Feature Config (record)
 * @param dense If the trees are dense
 */
public record QuartzTreeFeatureConfig(int dense) implements FeatureConfig {
    /**
     * Quartz Tree Feature Config constructor
     * @param dense If the trees are dense
     */
    public QuartzTreeFeatureConfig(int dense) { this.dense = dense; }

    /**
     * The codec of the feature config
     */
    public static Codec<QuartzTreeFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    Codecs.NONNEGATIVE_INT.fieldOf("dense").forGetter(QuartzTreeFeatureConfig::dense)
            ).apply(instance, QuartzTreeFeatureConfig::new)
    );

    /**
     * If the trees are dense
     * @return An int representing density
     */
    public int dense() { return this.dense; }
}
