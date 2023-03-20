package io.github.randomkiddo.entities.client;

import io.github.randomkiddo.entities.custom.EvilChickenEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EvilChickenRenderer extends GeoEntityRenderer<EvilChickenEntity> {

    public EvilChickenRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new EvilChickenModel());
    }

    @Override
    public Identifier getTextureLocation(EvilChickenEntity instance) {
        return new Identifier("chocolate", "textures/entities/evil_chicken/evil_chicken.png");
    }

}
