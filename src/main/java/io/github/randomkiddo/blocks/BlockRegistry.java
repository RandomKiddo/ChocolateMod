/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
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
            TILE_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    /**
     * Sandstone Brick Block
     */
    public static final Block SANDSTONE_BRICKS_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f));
    /**
     * Sandstone Brick Block as an item
     */
    public static final BlockItem SANDSTONE_BRICKS_ITEM = new BlockItem(
            SANDSTONE_BRICKS_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    /**
     * Polished Sandstone Block
     */
    public static final Block POLISHED_SANDSTONE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f));
    /**
     * Polished Sandstone Block as an item
     */
    public static final BlockItem POLISHED_SANDSTONE_ITEM = new BlockItem(
            POLISHED_SANDSTONE_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    /**
     * Red Sandstone Brick Block
     */
    public static final Block RED_SANDSTONE_BRICKS_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f));
    /**
     * Red Sandstone Brick Block as an item
     */
    public static final BlockItem RED_SANDSTONE_BRICKS_ITEM = new BlockItem(
            RED_SANDSTONE_BRICKS_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    /**
     * Red Polished Sandstone Block
     */
    public static final Block RED_POLISHED_SANDSTONE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f));
    /**
     * Red Polished Sandstone Block as an item
     */
    public static final BlockItem RED_POLISHED_SANDSTONE_ITEM = new BlockItem(
            RED_POLISHED_SANDSTONE_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));

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
    }
}
