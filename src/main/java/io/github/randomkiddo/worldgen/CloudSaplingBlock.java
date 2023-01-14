/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo
 */

package io.github.randomkiddo.worldgen;

import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;

/**
 * Represents a sapling block for the custom cloud tree
 *
 * @see SaplingBlock
 */
public class CloudSaplingBlock extends SaplingBlock {
    /**
     * Instantiates a new CloudSaplingBlock
     * @param generator The SaplingGenerator to use
     * @param settings The Settings to use
     * @see net.minecraft.block.AbstractBlock.Settings
     * @see SaplingGenerator
     */
    public CloudSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }
}
