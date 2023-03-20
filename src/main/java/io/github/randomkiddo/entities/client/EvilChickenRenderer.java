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
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

/**
 * Renders the Evil Chicken
 * @see GeoEntityRenderer
 */
public class EvilChickenRenderer extends GeoEntityRenderer<EvilChickenEntity> {
    /**
     * Default constructor, calls super constructor in GeoEntityRenderer
     * @param renderManager The render manager context
     * @see GeoEntityRenderer
     */
    public EvilChickenRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new EvilChickenModel());
    }

    /**
     * Fetches the texture location for the entity
     * @param instance The instance to get the texture for
     * @return An Identifier instance with reference to location
     * @see Identifier
     */
    @Override public Identifier getTextureLocation(EvilChickenEntity instance) {
        return new Identifier("chocolate", "textures/entities/evil_chicken/evil_chicken.png");
    }

}
