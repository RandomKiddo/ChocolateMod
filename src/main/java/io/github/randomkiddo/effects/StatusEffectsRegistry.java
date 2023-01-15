/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo
 */

package io.github.randomkiddo.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all status effects for this mod
 */
public class StatusEffectsRegistry {
    /**
     * The nullify status effect
     */
    public static final StatusEffect NULLIFY = new NullifyStatusEffect();
    /**
     * Freeze status effect
     */
    public static final StatusEffect FREEZE = new FreezeStatusEffect();
    /**
     * Numb status effect
     */
    public static final StatusEffect NUMB = new NumbStatusEffect();
    /**
     * Registers all the status effects above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier("chocolate", "nullify"), NULLIFY);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("chocolate", "freeze"), FREEZE);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("chocolate", "numb"), NUMB);
    }
}
