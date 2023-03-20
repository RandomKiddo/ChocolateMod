/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo;

import io.github.randomkiddo.config.ConfigRegistry;
import io.github.randomkiddo.entities.EntityRegistry;
import io.github.randomkiddo.entities.client.EvilChickenRenderer;
import io.github.randomkiddo.fluids.FluidRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

import static io.github.randomkiddo.blocks.BlockRegistry.*;
import static io.github.randomkiddo.fluids.FluidRegistry.STILL_CHOCOLATE_MILK;
import static io.github.randomkiddo.worldgen.trees.TreeRegistry.*;

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
        BlockRenderLayerMap.INSTANCE.putBlock(CLOUD_SAPLING, RenderLayer.getCutout()); // Register cloud sapling rendering
        BlockRenderLayerMap.INSTANCE.putBlock(PINK_CHERRY_SAPLING, RenderLayer.getCutout()); // Register pink cherry sapling rendering
        BlockRenderLayerMap.INSTANCE.putBlock(WHITE_CHERRY_SAPLING, RenderLayer.getCutout()); // Register white cherry sapling rendering
        if (!ConfigRegistry.USING_FAST_GRAPHICS) { //todo check Level data
            BlockRenderLayerMap.INSTANCE.putBlock(CLOUD_LEAVES, RenderLayer.getCutout()); // Register cloud leaves rendering
            BlockRenderLayerMap.INSTANCE.putBlock(PINK_CHERRY_LEAVES, RenderLayer.getCutout()); // Register pink cherry leaves rendering
            BlockRenderLayerMap.INSTANCE.putBlock(WHITE_CHERRY_LEAVES, RenderLayer.getCutout()); // Register white cherry leaves rendering
        }
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("chocolate:block/chocolate_milk_still"));
            registry.register(new Identifier("chocolate:block/chocolate_milk_flow"));
        });
        FluidRenderHandlerRegistry.INSTANCE.register(STILL_CHOCOLATE_MILK, FluidRegistry.FLOWING_CHOCOLATE_MILK,
                new SimpleFluidRenderHandler(
                        new Identifier("chocolate:block/chocolate_milk_still"),
                        new Identifier("chocolate:block/chocolate_milk_flow"),
                        0x84563c
                )
        ); //Register client-side of chocolate milk fluid
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), STILL_CHOCOLATE_MILK, FluidRegistry.FLOWING_CHOCOLATE_MILK);
        FluidRenderHandlerRegistry.INSTANCE.register(FluidRegistry.STILL_SOAP, FluidRegistry.FLOWING_SOAP,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xf522c4
                )
        ); //Register client-side of soap fluid
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), FluidRegistry.STILL_SOAP, FluidRegistry.FLOWING_SOAP);

        EntityRendererRegistry.register(EntityRegistry.EVIL_CHICKEN, EvilChickenRenderer::new); // Register client entity
    }
}
