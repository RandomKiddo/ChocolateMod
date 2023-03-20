/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.entities.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

/**
 * Evil Chicken Entity Class; Suppresses Deprecation Warnings
 * @see HostileEntity
 * @see IAnimatable
 */
@SuppressWarnings({ "deprecated" })
public class EvilChickenEntity extends HostileEntity implements IAnimatable {
    /**
     * The animation factory
     */
    @SuppressWarnings({ "deprecated" })
    private AnimationFactory factory = new AnimationFactory(this);

    /**
     * Constructs this entity
     * @param entityType The type of entity
     * @param world The world to live in
     */
    public EvilChickenEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * Creates a child on a server (unused, Deprecated)
     * @param world The world to perform this action on
     * @param entity The entity creating a child
     * @return A child HostileEntity instance
     */
    @Nullable
    @Deprecated
    public HostileEntity createChild(ServerWorld world, HostileEntity entity) {
        return null;
    }

    /**
     * Sets the entity attributes
     * @return A builder with all the entity attributes
     * @see DefaultAttributeContainer.Builder
     */
    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 4.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0f);
    }

    /**
     * Initializes the goals for the entity
     */
    protected void initGoals() {
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
    }

    /**
     * The play state predicate for the entity; Suppresses deprecated warnings
     * @param event The event to work on
     * @return A PlayState instance
     * @param <E> Some object E extending IAnimatable; The Entity
     * @see IAnimatable
     * @see PlayState
     */
    @SuppressWarnings({ "deprecated" })
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.evil_chicken.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.evil_chicken.idle", true));
        return PlayState.CONTINUE;
    }

    /**
     * Registers the entity controllers
     * @param animationData The entity's animation data
     */
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    /**
     * Gets the animation factory
     * @return The factory field
     * @see AnimationFactory
     */
    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    /**
     * Gets the ambient sound for the entity
     * @return SoundEvents.ENTITY_CHICKEN_AMBIENT
     * @see SoundEvents
     */
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    /**
     * Gets the hurt sound for the entity
     * @param source The source of the damage
     * @return SoundEvents.ENTITY_CHICKEN_HURT
     * @see SoundEvents
     */
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }
    /**
     * Gets the death sound for the entity
     * @return SoundEvents.ENTITY_CHICKEN_DEATH
     * @see SoundEvents
     */
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    /**
     * Plays the entity's step sound
     * @param pos The position to play the sound
     * @param state The state of the block at pos
     */
    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15f, 1.0f);
    }
}
