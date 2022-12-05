/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.effects;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all potions for this mod
 */
public class PotionsRegistry {
    /**
     * Registers all potions
     * @see Registry
     */
    public static void register() {
        // Nullify Potion
        Registry.register(Registry.POTION, new Identifier("chocolate", "nullify_potion"),
                new Potion(new StatusEffectInstance(StatusEffectsRegistry.NULLIFY, 60*20, 0)));
        // Freeze Potion
        Registry.register(Registry.POTION, new Identifier("chocolate", "freeze_potion"),
                new Potion(new StatusEffectInstance(StatusEffectsRegistry.FREEZE, 30*20, 0)));
    }
}
