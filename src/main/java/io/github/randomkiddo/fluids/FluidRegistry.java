/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.fluids;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.LakeFeature;

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
    @SuppressWarnings({ "deprecated" }) static LakeFeature ACID_LAKE; //todo lake generation

    /**
     * Registers all the fluid features above
     * @see Registry
     */
    @SuppressWarnings({ "deprecated" }) public static void register() {
        STILL_ACID = Registry.register(Registry.FLUID, new Identifier("chocolate", "still_acid"), new AcidFluid.Still());
        FLOWING_ACID = Registry.register(Registry.FLUID, new Identifier("chocolate", "flowing_acid"), new AcidFluid.Flowing());
        ACID_BUCKET = Registry.register(Registry.ITEM, new Identifier("chocolate", "acid_bucket"),
                new BucketItem(STILL_ACID, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
        ACID = Registry.register(Registry.BLOCK, new Identifier("chocolate", "acid"),
                new FluidBlock(STILL_ACID, FabricBlockSettings.copy(Blocks.WATER)));
        //ACID_LAKE = Registry.register(Registry.FEATURE, new Identifier("chocolate", "acid_lake"),
         //       new LakeFeature(SingleStateFeatureConfig::));
    }
}
