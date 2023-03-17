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
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import javax.tools.Tool;

/**
 * Registers all tools for this mod
 */
public class ToolRegistry {
    /**
     * Foselium pickaxe instance
     */
    public static ToolItem FOSELIUM_PICKAXE = new FoseliumPickaxeItem(FoseliumMaterial.INSTANCE, 2, -2.8F, new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));

    public static ToolItem ETHERIUM_SWORD = new EtheriumSwordItem(EtheriumMaterial.INSTANCE, 6, -2.4F, new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    /**ium
    /**
     * Chocolate shovel instance
     */
    public static ToolItem CHOCOLATE_SHOVEL = new ShovelItem(ChocolateMaterial.INSTANCE, 1.5F, -3.0F,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP).food(new FoodComponent.Builder().hunger(4).saturationModifier(6f).snack().build()));
    /**
     * Chocolate sword instance
     */
    public static ToolItem CHOCOLATE_SWORD = new SwordItem(ChocolateMaterial.INSTANCE, 3, -2.4F,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP).food(new FoodComponent.Builder().hunger(7).saturationModifier(10f).snack().build()));
    /**
     * Chocolate pickaxe instance
     */
    public static ToolItem CHOCOLATE_PICKAXE = new ChocolatePickaxeItem(ChocolateMaterial.INSTANCE, 1, -2.8F,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP).food(new FoodComponent.Builder().hunger(9).saturationModifier(12f).snack().build()));
    /**
     * Chocolate axe instance
     */
    public static ToolItem CHOCOLATE_AXE = new ChocolateAxeItem(ChocolateMaterial.INSTANCE, 4, -3.2F,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP).food(new FoodComponent.Builder().hunger(9).saturationModifier(12f).snack().build()));
    /**
     * Chocolate hoe instance
     */
    public static ToolItem CHOCOLATE_HOE = new ChocolateHoeItem(ChocolateMaterial.INSTANCE, 1, -3.2F,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP).food(new FoodComponent.Builder().hunger(7).saturationModifier(10f).snack().build()));
    /**
     * Chocolate sword instance
     */
    public static ToolItem COPPER_SWORD = new CopperSwordItem(CopperMaterial.INSTANCE, 3, -2.4F,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Chocolate pickaxe instance
     */
    public static ToolItem COPPER_PICKAXE = new CopperPickaxeItem(CopperMaterial.INSTANCE, 1, -2.8F,
            new Item.Settings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Registers all the tool instances above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("chocolate", "foselium_pickaxe"), FOSELIUM_PICKAXE);
        Registry.register(Registry.ITEM,  new Identifier("chocolate", "etherium_sword"), ETHERIUM_SWORD);

        Registry.register(Registry.ITEM, new Identifier("chocolate", "chocolate_shovel"), CHOCOLATE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "chocolate_sword"), CHOCOLATE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "chocolate_pickaxe"), CHOCOLATE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "chocolate_axe"), CHOCOLATE_AXE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "chocolate_hoe"), CHOCOLATE_HOE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "copper_pickaxe"), COPPER_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "copper_sword"), COPPER_SWORD);
    }
}