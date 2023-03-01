/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.blocks;

import io.github.randomkiddo.Chocolate;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all blocks and their item equivalents for this mod
 */
public class BlockRegistry {
    /**
     * Tile Block
     */
    public static final Block TILE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.5f));
    /**
     * Tile Block as an item
     */
    public static final BlockItem TILE_ITEM = new BlockItem(
            TILE_BLOCK, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Sandstone Brick Block
     */
    public static final Block SANDSTONE_BRICKS_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f));
    /**
     * Sandstone Brick Block as an item
     */
    public static final BlockItem SANDSTONE_BRICKS_ITEM = new BlockItem(
            SANDSTONE_BRICKS_BLOCK, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Polished Sandstone Block
     */
    public static final Block POLISHED_SANDSTONE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f));
    /**
     * Polished Sandstone Block as an item
     */
    public static final BlockItem POLISHED_SANDSTONE_ITEM = new BlockItem(
            POLISHED_SANDSTONE_BLOCK, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Red Sandstone Brick Block
     */
    public static final Block RED_SANDSTONE_BRICKS_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f));
    /**
     * Red Sandstone Brick Block as an item
     */
    public static final BlockItem RED_SANDSTONE_BRICKS_ITEM = new BlockItem(
            RED_SANDSTONE_BRICKS_BLOCK, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Red Polished Sandstone Block
     */
    public static final Block RED_POLISHED_SANDSTONE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f));
    /**
     * Red Polished Sandstone Block as an item
     */
    public static final BlockItem RED_POLISHED_SANDSTONE_ITEM = new BlockItem(
            RED_POLISHED_SANDSTONE_BLOCK, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Foselium Ore Block
     */
    public static final Block FOSELIUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f, 9.0f));
    /**
     * Foselium Ore Block as an item
     */
    public static final BlockItem FOSELIUM_ORE_ITEM = new BlockItem(
            FOSELIUM_ORE, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Cloud Logs Block
     */
    public static final Block CLOUD_LOGS = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f));
    /**
     * Cloud Logs Block as an item
     */
    public static final BlockItem CLOUD_LOGS_ITEM = new BlockItem(
            CLOUD_LOGS, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Cloud Planks Block
     */
    public static final Block CLOUD_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f));
    /**
     * Cloud Planks Block as an item
     */
    public static final BlockItem CLOUD_PLANKS_ITEM = new BlockItem(
            CLOUD_PLANKS, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Cloud Leaves Block (nonOpaque helps with rendering)
     */
    public static final Block CLOUD_LEAVES = new Block(FabricBlockSettings.of(Material.LEAVES).strength(0.2f, 0.2f).nonOpaque());
    /**
     * Cloud Leaves Block as an item
     */
    public static final BlockItem CLOUD_LEAVES_ITEM = new BlockItem(
            CLOUD_LEAVES, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Milk Chocolate Block
     */
    public static final Block MILK_CHOCOLATE = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.0f, 1.0f));
    /**
     * Milk Chocolate Block as an item
     */
    public static final BlockItem MILK_CHOCOLATE_ITEM = new BlockItem(
            MILK_CHOCOLATE, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Dark Chocolate Block
     */
    public static final Block DARK_CHOCOLATE = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.0f, 1.0f));
    /**
     * Dark Chocolate Block as an item
     */
    public static final BlockItem DARK_CHOCOLATE_ITEM = new BlockItem(
            DARK_CHOCOLATE, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Etherium Ore Block
     */
    public static final Block ETHERIUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f, 9.0f));
    /**
     * Etherium Ore Block as an item
     */
    public static final BlockItem ETHERIUM_ORE_ITEM = new BlockItem(
            ETHERIUM_ORE, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Pink Cherry Logs Block
     */
    public static final Block PINK_CHERRY_LOGS = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f));
    /**
     * Pink Cherry Logs Block as an item
     */
    public static final BlockItem PINK_CHERRY_LOGS_ITEM = new BlockItem(
            PINK_CHERRY_LOGS, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Pink Cherry Planks Block
     */
    public static final Block PINK_CHERRY_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f));
    /**
     * Pink Cherry Planks Block as an item
     */
    public static final BlockItem PINK_CHERRY_PLANKS_ITEM = new BlockItem(
            PINK_CHERRY_PLANKS, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Pink Cherry Leaves Block (nonOpaque helps with rendering)
     */
    public static final Block PINK_CHERRY_LEAVES = new Block(FabricBlockSettings.of(Material.LEAVES).strength(0.2f, 0.2f).nonOpaque());
    /**
     * Pink Cherry Leaves Block as an item
     */
    public static final BlockItem PINK_CHERRY_LEAVES_ITEM = new BlockItem(
            PINK_CHERRY_LEAVES, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * White Cherry Logs Block
     */
    public static final Block WHITE_CHERRY_LOGS = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f));
    /**
     * White Cherry Logs Block as an item
     */
    public static final BlockItem WHITE_CHERRY_LOGS_ITEM = new BlockItem(
            WHITE_CHERRY_LOGS, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * White Cherry Planks Block
     */
    public static final Block WHITE_CHERRY_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f));
    /**
     * White Cherry Planks Block as an item
     */
    public static final BlockItem WHITE_CHERRY_PLANKS_ITEM = new BlockItem(
            WHITE_CHERRY_PLANKS, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * White Cherry Leaves Block (nonOpaque helps with rendering)
     */
    public static final Block WHITE_CHERRY_LEAVES = new Block(FabricBlockSettings.of(Material.LEAVES).strength(0.2f, 0.2f).nonOpaque());
    /**
     * White Cherry Leaves Block as an item
     */
    public static final BlockItem WHITE_CHERRY_LEAVES_ITEM = new BlockItem(
            WHITE_CHERRY_LEAVES, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     *  Quartz Stem Block
     */
    public static final Block QUARTZ_STEM = new Block(FabricBlockSettings.of(Material.NETHER_WOOD).strength(0.2f, 0.2f));
    /**
     * White Cherry Leaves Block as an item
     */
    public static final BlockItem QUARTZ_STEM_ITEM = new BlockItem(
            QUARTZ_STEM, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
    /**
     * Registers all the blocks and items above
     * @see Registry
     */
    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "tile_block"), TILE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "tile_block"), TILE_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "sandstone_brick"), SANDSTONE_BRICKS_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "sandstone_brick"), SANDSTONE_BRICKS_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "polished_sandstone"), POLISHED_SANDSTONE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "polished_sandstone"), POLISHED_SANDSTONE_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "red_brick"), RED_SANDSTONE_BRICKS_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "red_brick"), RED_SANDSTONE_BRICKS_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "red_polished"), RED_POLISHED_SANDSTONE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "red_polished"), RED_POLISHED_SANDSTONE_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "foselium_ore"), FOSELIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "foselium_ore"), FOSELIUM_ORE_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "cloud_logs"), CLOUD_LOGS);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "cloud_logs"), CLOUD_LOGS_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "cloud_planks"), CLOUD_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "cloud_planks"), CLOUD_PLANKS_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "cloud_leaves"), CLOUD_LEAVES);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "cloud_leaves"), CLOUD_LEAVES_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "milk_chocolate"), MILK_CHOCOLATE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "milk_chocolate"), MILK_CHOCOLATE_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "dark_chocolate"), DARK_CHOCOLATE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "dark_chocolate"), DARK_CHOCOLATE_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "etherium_ore"), ETHERIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "etherium_ore"), ETHERIUM_ORE_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "pink_cherry_logs"), PINK_CHERRY_LOGS);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "pink_cherry_logs"), PINK_CHERRY_LOGS_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "pink_cherry_planks"), PINK_CHERRY_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "pink_cherry_planks"), PINK_CHERRY_PLANKS_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "pink_cherry_leaves"), PINK_CHERRY_LEAVES);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "pink_cherry_leaves"), PINK_CHERRY_LEAVES_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "white_cherry_logs"), WHITE_CHERRY_LOGS);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "white_cherry_logs"), WHITE_CHERRY_LOGS_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "white_cherry_planks"), WHITE_CHERRY_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "white_cherry_planks"), WHITE_CHERRY_PLANKS_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "white_cherry_leaves"), WHITE_CHERRY_LEAVES);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "white_cherry_leaves"), WHITE_CHERRY_LEAVES_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("chocolate", "quartz_stem"), QUARTZ_STEM);
        Registry.register(Registry.ITEM, new Identifier("chocolate", "quartz_stem"), QUARTZ_STEM_ITEM);
        FuelRegistry.INSTANCE.add(CLOUD_PLANKS_ITEM, 100); // Makes the wood smelt-able
        FuelRegistry.INSTANCE.add(CLOUD_LOGS_ITEM, 200);
        FuelRegistry.INSTANCE.add(WHITE_CHERRY_PLANKS_ITEM, 100);
        FuelRegistry.INSTANCE.add(WHITE_CHERRY_LOGS_ITEM, 200);
        FuelRegistry.INSTANCE.add(PINK_CHERRY_PLANKS_ITEM, 100);
        FuelRegistry.INSTANCE.add(PINK_CHERRY_LOGS_ITEM, 200);
    }
}
