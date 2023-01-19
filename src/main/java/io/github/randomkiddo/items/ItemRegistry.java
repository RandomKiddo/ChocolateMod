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
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all status effects for this mod
 */
public class ItemRegistry {
    public static final Item SOAP = new Item(new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Registers all the status effects above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("chocolate", "soap"), SOAP);
    }
}
