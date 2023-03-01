/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.items;

import io.github.randomkiddo.Chocolate;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all items for this mod
 */
public class ItemRegistry {
    /**
     * Soap item
     */
    public static final Item SOAP = new Item(new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Long bread item
     */
    public static final Item LONG_BREAD = new Item(new Item.Settings().group(Chocolate.CHOCOLATE_GROUP).food(
            new FoodComponent.Builder().hunger(10).saturationModifier(12f).build()));
    /**
     * Baguette item
     */
    public static final Item BAGUETTE = new Item(new Item.Settings().group(Chocolate.CHOCOLATE_GROUP).food(
            new FoodComponent.Builder().hunger(16).saturationModifier(17f).build()));
    /**
     * Registers all the status effects above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("chocolate", "soap"), SOAP);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "long_bread"), LONG_BREAD);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "baguette"), BAGUETTE);
    }
}
