/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static io.github.randomkiddo.chocolates.ChocolateRegistry.*;
import static io.github.randomkiddo.ores.IngotRegistry.FOSELIUM_INGOT;
import static io.github.randomkiddo.tools.ToolRegistry.FOSELIUM_PICKAXE;
import static io.github.randomkiddo.worldgen.biome.OverworldBiomes.CLOUD_FOREST_KEY;


public class AdvancementsProvider extends FabricAdvancementProvider {
    protected AdvancementsProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }
    @Override public void generateAdvancement(Consumer<Advancement> consumer) {
        new Advancements().accept(consumer);
    }
    static class Advancements implements Consumer<Consumer<Advancement>> {
        @Override public void accept(Consumer<Advancement> consumer) {
            Advancement rootAdvancement = Advancement.Builder.create()
                    .display(
                            Items.COCOA_BEANS,
                            Text.literal("Chocolate"),
                            Text.literal("The wonders of a new flavor"),
                            new Identifier("chocolate:textures/block/cloud_planks.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .criterion("got_cocoa_beans", InventoryChangedCriterion.Conditions.items(Items.COCOA_BEANS))
                    .build(consumer, "chocolate" + "/root");
            Advancement roastedCocoaBeans = Advancement.Builder.create()
                    .display(
                            ROASTED_COCOA_BEANS,
                            Text.literal("Roasted Cocoa Beans"),
                            Text.literal("What are you up to?"),
                            new Identifier("chocolate:textures/block/cloud_planks.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .parent(rootAdvancement)
                    .criterion("got_roasted_cocoa_beans", InventoryChangedCriterion.Conditions.items(ROASTED_COCOA_BEANS))
                    .build(consumer, "chocolate" + "/roasted_cocoa_beans");
            Advancement cocoaButter = Advancement.Builder.create()
                    .display(
                            COCOA_BUTTER,
                            Text.literal("Cocoa Butter"),
                            Text.literal("Chocolate Butter?"),
                            new Identifier("chocolate:textures/block/cloud_planks.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .parent(roastedCocoaBeans)
                    .criterion("got_cocoa_butter", InventoryChangedCriterion.Conditions.items(COCOA_BUTTER))
                    .build(consumer, "chocolate" + "/cocoa_butter");
            Advancement chocolateLiquor = Advancement.Builder.create()
                    .display(
                            CHOCOLATE_LIQUOR,
                            Text.literal("Chocolate Liquor"),
                            Text.literal("LIQUOR? Wait..."),
                            new Identifier("chocolate:textures/block/cloud_planks.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .parent(cocoaButter)
                    .criterion("got_chocolate_liquor", InventoryChangedCriterion.Conditions.items(CHOCOLATE_LIQUOR))
                    .build(consumer, "chocolate" + "/chocolate_liquor");
            Advancement chocolate = Advancement.Builder.create()
                    .display(
                            CHOCOLATE,
                            Text.literal("CHOCOLATE"),
                            Text.literal("CHOCOLATE!"),
                            new Identifier("chocolate:textures/block/cloud_planks.png"),
                            AdvancementFrame.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .parent(chocolateLiquor)
                    .criterion("got_chocolate", InventoryChangedCriterion.Conditions.items(CHOCOLATE))
                    .build(consumer, "chocolate" + "/chocolate");
            Advancement foselium = Advancement.Builder.create()
                    .display(
                            FOSELIUM_INGOT,
                            Text.literal("Foselium Ingot"),
                            Text.literal("What is this? Fossilized Extract?"),
                            new Identifier("chocolate:textures/block/cloud_planks.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .parent(rootAdvancement)
                    .criterion("got_foselium", InventoryChangedCriterion.Conditions.items(FOSELIUM_INGOT))
                    .build(consumer, "chocolate" + "/foselium");
            Advancement foseliumPickaxe = Advancement.Builder.create()
                    .display(
                            FOSELIUM_PICKAXE,
                            Text.literal("Foselium Pickaxe"),
                            Text.literal("What kind of sorcery is this?"),
                            new Identifier("chocolate:textures/block/cloud_planks.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .parent(foselium)
                    .criterion("got_foselium_pickaxe", InventoryChangedCriterion.Conditions.items(FOSELIUM_PICKAXE))
                    .build(consumer, "chocolate" + "/foselium_pickaxe");
            Advancement cloudForest = Advancement.Builder.create()
                    .display(
                            Items.WHITE_STAINED_GLASS_PANE,
                            Text.literal("Cloud Forest"),
                            Text.literal("Wow, it's beautiful!"),
                            new Identifier("chocolate:textures/block/cloud_planks.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .parent(rootAdvancement)
                    .criterion("in_cloud_forest", TickCriterion.Conditions.createLocation(LocationPredicate.biome(CLOUD_FOREST_KEY)))
                    .build(consumer, "chocolate" + "/cloud_forest");
            Advancement darkChocolate = Advancement.Builder.create()
                    .display(
                            DARK_CHOCOLATE,
                            Text.literal("HEALTHIER CHOCOLATE"),
                            Text.literal("MORE CHOCOLATE!"),
                            new Identifier("chocolate:textures/block/cloud_planks.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .parent(chocolateLiquor)
                    .criterion("got_chocolate_dark", InventoryChangedCriterion.Conditions.items(DARK_CHOCOLATE))
                    .build(consumer, "chocolate" + "/chocolate_dark");
        }
    }
}
