/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.ores;

import io.github.randomkiddo.Chocolate;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all ingots for this mod
 */
public class IngotRegistry {
    /**
     * Foselium ingot item
     */
    public static final Item FOSELIUM_INGOT = new Item(new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));

    /**
     * Etherium ingot item
     */
    public static final Item ETHERIUM_INGOT = new Item(new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));

    /**
     * Registers all the ore features above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("chocolate", "foselium_ingot"), FOSELIUM_INGOT);
        FuelRegistry.INSTANCE.add(FOSELIUM_INGOT, 300); // Foselium smelt-able
        Registry.register(Registry.ITEM, new Identifier("chocolate", "etherium_ingot"), ETHERIUM_INGOT);
        FuelRegistry.INSTANCE.add(ETHERIUM_INGOT, 301); // Etherium smelt-able
    }


}
