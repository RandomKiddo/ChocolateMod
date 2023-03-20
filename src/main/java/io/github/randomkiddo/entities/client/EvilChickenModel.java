/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.entities.client;

import io.github.randomkiddo.entities.custom.EvilChickenEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

/**
 * Evil Chicken Model; Suppresses Deprecated Warnings
 * @see AnimatedGeoModel
 */
@SuppressWarnings({ "deprecated" })
public class EvilChickenModel extends AnimatedGeoModel<EvilChickenEntity> {
    /**
     * Gets the model resource
     * @param object The entity instance to fetch on
     * @return An Identifier instance referencing location
     * @see Identifier
     */
    @Override
    public Identifier getModelResource(EvilChickenEntity object) {
        return new Identifier("chocolate", "geo/evil_chicken.geo.json");
    }

    /**
     * Gets the location of the texture resource
     * @param object The entity instance to fetch on
     * @return An Identifier instance referencing location
     * @see Identifier
     */
    @Override
    public Identifier getTextureResource(EvilChickenEntity object) {
        return new Identifier("chocolate", "textures/entities/evil_chicken/evil_chicken.png");
    }

    /**
     * Gets the animation resource location
     * @param animatable The entity instance to fetch on
     * @return An Identifier instance referencing location
     * @see Identifier
     */
    @Override
    public Identifier getAnimationResource(EvilChickenEntity animatable) {
        return new Identifier("chocolate", "animations/evil_chicken.animation.json");
    }

    /**
     * Sets the living animation for the entity; Suppresses unchecked, raw type, and deprecated warnings
     * @param entity The entity to set animations on
     * @param uniqueID The UID of the entity
     * @param customPredicate The animation event predicate
     */
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
