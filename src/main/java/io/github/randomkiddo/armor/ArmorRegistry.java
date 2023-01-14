/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo
 */

package io.github.randomkiddo.armor;

import io.github.randomkiddo.Chocolate;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all armor items
 */
public class ArmorRegistry {
    /**
     * Emerald armor material instance
     */
    public static final ArmorMaterial EMERALD_ARMOR_MATERIAL = new EmeraldMaterial();
    /**
     * Physical emerald material
     */
    public static final Item EMERALD_MATERIAL = Items.EMERALD;
    /**
     * Emerald helmet item
     */
    public static final Item EMERALD_HELMET = new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.HEAD,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Emerald chestplate item
     */
    public static final Item EMERALD_CHESTPLATE = new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.CHEST,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Emerald leggings item
     */
    public static final Item EMERALD_LEGGINGS = new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.LEGS,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Emerald boots item
     */
    public static final Item EMERALD_BOOTS = new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.FEET,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Registers all the items above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("chocolate", "emerald_helmet"), EMERALD_HELMET);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "emerald_chestplate"), EMERALD_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "emerald_leggings"), EMERALD_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "emerald_boots"), EMERALD_BOOTS);
    }
}
