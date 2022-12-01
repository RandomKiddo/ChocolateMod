package io.github.randomkiddo.armor;

import io.github.randomkiddo.Chocolate;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmorRegistry {
    public static final ArmorMaterial EMERALD_ARMOR_MATERIAL = new EmeraldMaterial();
    public static final Item EMERALD_MATERIAL = Items.EMERALD;
    public static final Item EMERALD_HELMET = new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.HEAD,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    public static final Item EMERALD_CHESTPLATE = new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.CHEST,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    public static final Item EMERALD_LEGGINGS = new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.LEGS,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    public static final Item EMERALD_BOOTS = new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.FEET,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("chocolate", "emerald_helmet"), EMERALD_HELMET);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "emerald_chestplate"), EMERALD_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "emerald_leggings"), EMERALD_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "emerald_boots"), EMERALD_BOOTS);
    }
}
