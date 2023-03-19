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
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static io.github.randomkiddo.chocolates.ChocolateRegistry.*;


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
        }
    }
}
