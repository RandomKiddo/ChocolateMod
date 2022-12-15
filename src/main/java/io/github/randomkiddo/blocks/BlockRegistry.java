/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
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
     * Cloud Leaves Block
     */
    public static final Block CLOUD_LEAVES = new Block(FabricBlockSettings.of(Material.LEAVES).strength(0.2f, 0.2f));
    /**
     * Cloud Leaves Block as an item
     */
    public static final BlockItem CLOUD_LEAVES_ITEM = new BlockItem(
            CLOUD_LEAVES, new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP));
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
        FuelRegistry.INSTANCE.add(CLOUD_PLANKS_ITEM, 100); // Makes the wood smelt-able
        FuelRegistry.INSTANCE.add(CLOUD_LOGS_ITEM, 200);
    }
}
