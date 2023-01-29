/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.effects;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
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
        //Numb Potion
        Registry.register(Registry.POTION, new Identifier("chocolate", "numb_potion"),
                new Potion(new StatusEffectInstance(StatusEffectsRegistry.NUMB, 30, 0)));
        // Register Recipes
        BrewingRecipeRegistry.registerPotionRecipe(
                Potions.THICK,
                Items.GLASS,
                Potion.byId("chocolate:nullify_potion")
        );
        BrewingRecipeRegistry.registerPotionRecipe(
                Potions.THICK,
                Items.ICE,
                Potion.byId("chocolate:freeze_potion")
        );
        BrewingRecipeRegistry.registerPotionRecipe(
                Potions.THICK,
                Items.SNOW_BLOCK,
                Potion.byId("chocolate:numb_potion")
        );
    }
}
