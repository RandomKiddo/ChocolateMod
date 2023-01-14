/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo
 */

package io.github.randomkiddo.enchants;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all enchantments for this mod
 */
public class EnchantmentRegistry {
    /**
     * Physically registers all enchantments in this mod
     * @see Registry
     */
    public static void register() {
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "adrenaline"),
                new AdrenalineEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "lightweight"),
                new LightweightEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "wince"),
                new WinceEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "aqua_aspect"),
                new AquaAspectEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "vampire"),
                new VampireEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "experience"),
                new ExperienceEnchantment()
        );
    }
}
