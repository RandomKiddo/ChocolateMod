/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.tools;

import io.github.randomkiddo.Chocolate;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all tools for this mod
 */
public class ToolRegistry {
    /**
     * Foselium pickaxe instance
     */
    public static ToolItem FOSELIUM_PICKAXE = new FoseliumPickaxeItem(FoseliumMaterial.INSTANCE, 2, -2.8F, new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));

    /**
     * Registers all the tool instances above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("chocolate", "foselium_pickaxe"), FOSELIUM_PICKAXE);
    }
}
//todo texture for pickaxe