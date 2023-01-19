/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo;

import io.github.randomkiddo.armor.ArmorRegistry;
import io.github.randomkiddo.blocks.BlockRegistry;
import io.github.randomkiddo.chocolates.ChocolateRegistry;
import io.github.randomkiddo.effects.PotionsRegistry;
import io.github.randomkiddo.effects.StatusEffectsRegistry;
import io.github.randomkiddo.enchants.*;
import io.github.randomkiddo.fluids.FluidRegistry;
import io.github.randomkiddo.items.ItemRegistry;
import io.github.randomkiddo.ores.IngotRegistry;
import io.github.randomkiddo.ores.OreRegistry;
import io.github.randomkiddo.tools.ToolRegistry;
import io.github.randomkiddo.worldgen.BiomeModificationsRegistry;
import io.github.randomkiddo.worldgen.TreeRegistry;
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
		ChocolateRegistry.register();
		FluidRegistry.register();
		TreeRegistry.register();
		BiomeModificationsRegistry.register();
		ToolRegistry.register();
		ItemRegistry.register();
	}
}
