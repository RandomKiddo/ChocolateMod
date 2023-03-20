package io.github.randomkiddo.entities;

import io.github.randomkiddo.Chocolate;
import io.github.randomkiddo.entities.custom.EvilChickenEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static software.bernie.example.registry.RegistryUtils.registerItem;

public class EntityRegistry {
    public static final EntityType<EvilChickenEntity> EVIL_CHICKEN = Registry.register(
            Registry.ENTITY_TYPE, new Identifier("chocolate", "evil_chicken"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EvilChickenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final Item EVIL_CHICKEN_SPAWN_EGG = registerItem("evil_chicken_spawn_egg",
            new SpawnEggItem(EntityRegistry.EVIL_CHICKEN, 0x948e8d, 0x3b3635,
                    new FabricItemSettings().group(Chocolate.CHOCOLATE_GROUP).maxCount(1)));

    public static void registerModStuffs() {
        registerAttributes();
    }z

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(EntityRegistry.EVIL_CHICKEN, EvilChickenEntity.setAttributes());
    }

}

