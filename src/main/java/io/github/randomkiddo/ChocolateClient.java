/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo;

import io.github.randomkiddo.fluids.FluidRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import static io.github.randomkiddo.blocks.BlockRegistry.CLOUD_LEAVES;
import static io.github.randomkiddo.worldgen.TreeRegistry.CLOUD_SAPLING;

/**
 * This class registers and initializes the entire mod's client-side. It is called internally by the Fabric API.
 * @see ClientModInitializer
 * @see Environment
 */
@Environment(EnvType.CLIENT)
public class ChocolateClient implements ClientModInitializer {
    /**
     * Initializes the mod's client-side
     */
    @Override public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(FluidRegistry.STILL_ACID, FluidRegistry.FLOWING_ACID,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0x42f548
                )
        ); //Register client-side of acid fluid
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), FluidRegistry.STILL_ACID, FluidRegistry.FLOWING_ACID);
        BlockRenderLayerMap.INSTANCE.putBlock(CLOUD_SAPLING, RenderLayer.getCutout()); // Render saplings properly
        BlockRenderLayerMap.INSTANCE.putBlock(CLOUD_LEAVES, RenderLayer.getCutout()); // Render leaves properly
    }
}
