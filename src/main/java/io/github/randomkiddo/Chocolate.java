/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 */

package io.github.randomkiddo;

import io.github.randomkiddo.blocks.BlockRegistry;
import io.github.randomkiddo.enchants.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Chocolate implements ModInitializer {
	public static final ItemGroup CHOCOLATE_GROUP = FabricItemGroupBuilder.create(
			new Identifier("chocolate", "chocolate_group"))
			.icon(() -> new ItemStack(Items.LEATHER_BOOTS))
			.build();
	@Override
	public void onInitialize() {
		EnchantmentRegistry.register();
		BlockRegistry.register();
	}
}
