package io.github.randomkiddo.entities.client;

import io.github.randomkiddo.entities.custom.EvilChickenEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@SuppressWarnings({ "deprecated" })
public class EvilChickenModel extends AnimatedGeoModel<EvilChickenEntity> {

    @Override
    public Identifier getModelResource(EvilChickenEntity object) {
        return new Identifier("chocolate", "geo/evil_chicken.geo.json");
    }

    @Override
    public Identifier getTextureResource(EvilChickenEntity object) {
        return new Identifier("chocolate", "textures/entities/evil_chicken/evil_chicken.png");
    }

    @Override
    public Identifier getAnimationResource(EvilChickenEntity animatable) {
        return new Identifier("chocolate", "animations/evil_chicken.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes", "deprecated" })
    @Override
    public void setLivingAnimations(EvilChickenEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
