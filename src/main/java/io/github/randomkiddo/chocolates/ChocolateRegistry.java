/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.chocolates;

import io.github.randomkiddo.Chocolate;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all actual chocolate relating items
 */
public class ChocolateRegistry {
    /**
     * Roasted cocoa beans
     */
    public static final Item ROASTED_COCOA_BEANS = new Item(new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Cocoa butter
     */
    public static final Item COCOA_BUTTER = new Item(new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Chocolate liquor
     */
    public static final Item CHOCOLATE_LIQUOR = new Item(new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Chocolate
     */
    public static final Item CHOCOLATE = new Item(new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(6f).snack().build()));

    /**
     * Registers all the items above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("chocolate", "roasted_cocoa_beans"), ROASTED_COCOA_BEANS);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "cocoa_butter"), COCOA_BUTTER);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "chocolate_liquor"), CHOCOLATE_LIQUOR);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "chocolate"), CHOCOLATE);
    }
}