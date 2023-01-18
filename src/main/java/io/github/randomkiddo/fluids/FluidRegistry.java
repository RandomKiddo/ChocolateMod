/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.fluids;

import io.github.randomkiddo.Chocolate;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers all fluids for this mod
 */
public class FluidRegistry {
    /**
     * Represents the still FlowableFluid of Acid
     * @see AcidFluid
     */
    public static FlowableFluid STILL_ACID;
    /**
     * Represents the flowing FlowableFluid of Acid
     * @see AcidFluid
     */
    public static FlowableFluid FLOWING_ACID;
    /**
     * Represents the bucket item of Acid
     * @see AcidFluid
     */
    public static Item ACID_BUCKET;
    /**
     * Represents the block version of Acid
     * @see AcidFluid
     */
    public static Block ACID;

    /**
     * Represents the still FlowableFluid of soap
     * @see SoapFluid
     */
    public static FlowableFluid STILL_SOAP;
    /**
     * Represents the flowing FlowableFluid of soap
     * @see SoapFluid
     */
    public static FlowableFluid FLOWING_SOAP;
    /**
     * Represents the bucket item of soap
     * @see SoapFluid
     */
    public static Item SOAP_BUCKET;
    /**
     * Represents the block version of soap
     * @see SoapFluid
     */
    public static Block SOAP;

    /**
     * Registers all the fluid features above
     * @see Registry
     */
    public static void register() {
        STILL_ACID = Registry.register(Registry.FLUID, new Identifier("chocolate", "still_acid"), new AcidFluid.Still());
        FLOWING_ACID = Registry.register(Registry.FLUID, new Identifier("chocolate", "flowing_acid"), new AcidFluid.Flowing());
        ACID_BUCKET = Registry.register(Registry.ITEM, new Identifier("chocolate", "acid_bucket"),
                new BucketItem(STILL_ACID, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(Chocolate.CHOCOLATE_GROUP)));
        ACID = Registry.register(Registry.BLOCK, new Identifier("chocolate", "acid"),
                new FluidBlock(STILL_ACID, FabricBlockSettings.copy(Blocks.WATER).mapColor(MapColor.EMERALD_GREEN)));
        STILL_SOAP = Registry.register(Registry.FLUID, new Identifier("chocolate", "still_soap"), new SoapFluid.Still());
        FLOWING_SOAP = Registry.register(Registry.FLUID, new Identifier("chocolate", "flowing_soap"), new SoapFluid.Flowing());
        SOAP_BUCKET = Registry.register(Registry.ITEM, new Identifier("chocolate", "soap_bucket"),
                new BucketItem(STILL_SOAP, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(Chocolate.CHOCOLATE_GROUP)));
        SOAP = Registry.register(Registry.BLOCK, new Identifier("chocolate", "soap"),
                new FluidBlock(STILL_SOAP, FabricBlockSettings.copy(Blocks.WATER).mapColor(MapColor.PINK)));
    }
}
