/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo;

import io.github.randomkiddo.armor.ArmorRegistry;
import io.github.randomkiddo.blocks.BlockRegistry;
import io.github.randomkiddo.effects.PotionsRegistry;
import io.github.randomkiddo.effects.StatusEffectsRegistry;
import io.github.randomkiddo.enchants.*;
import io.github.randomkiddo.ores.IngotRegistry;
import io.github.randomkiddo.ores.OreRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

/**
 * This class registers and initializes the entire mod. It is called internally by the Fabric API.
 * @see ModInitializer
 */
public class Chocolate implements ModInitializer {
	/**
	 * Builds an ItemGroup for this mod
	 * @see ItemGroup
	 */
	public static final ItemGroup CHOCOLATE_GROUP = FabricItemGroupBuilder.create(
			new Identifier("chocolate", "chocolate_group"))
			.icon(() -> new ItemStack(Items.COCOA_BEANS))
			.build();

	/**
	 * Initializes the mod
	 */
	@Override public void onInitialize() {
		EnchantmentRegistry.register();
		BlockRegistry.register();
		ArmorRegistry.register();
		StatusEffectsRegistry.register();
		PotionsRegistry.register();
		OreRegistry.register();
		IngotRegistry.register();
	}
}

//todo mod image
