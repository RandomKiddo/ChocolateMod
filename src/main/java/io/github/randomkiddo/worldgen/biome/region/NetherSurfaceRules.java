/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.worldgen.biome.region;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

/**
 * Surface rules for the nether
 */
public class NetherSurfaceRules {
    /**
     * Default Netherrack surface rule
     */
    private static final MaterialRules.MaterialRule NETHERRACK = MaterialRules.block(Blocks.NETHERRACK.getDefaultState());

    /**
     * Make the state rules for surfaces
     * @return A full MaterialRule sequence
     * @see net.minecraft.world.gen.surfacebuilder.MaterialRules.MaterialRule
     */
    public static MaterialRules.MaterialRule makeStateRules() {
        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.surface(), NETHERRACK)
        );
    }
}
