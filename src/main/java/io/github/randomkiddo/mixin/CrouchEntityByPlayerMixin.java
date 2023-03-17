package io.github.randomkiddo.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.Predicate;

@Mixin(Entity.class)
public class CrouchEntityByPlayerMixin {
    @Inject(method = "setSneaking(Z)V", at = @At("RETURN"), cancellable = false)
    private void mixin(boolean isSneaking, CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;

        if (entity instanceof PlayerEntity player && isSneaking) {

            final BlockPos topCorner = player.getBlockPos().add(2, 2, 2);
            final BlockPos bottomCorner = player.getBlockPos().add(-2, -2, -2);
            final World playerWorld = player.getWorld();
            final List<AnimalEntity> animalEntities = playerWorld.getEntitiesByClass(AnimalEntity.class, new Box(topCorner, bottomCorner), new Predicate<AnimalEntity>() {
                @Override
                public boolean test(AnimalEntity animalEntity) {
                    return !animalEntity.isBaby();
                }
            });

            final double x = player.getX();
            final double y = player.getY();
            final double z = player.getZ();
            final AnimalEntity closestEntity = playerWorld.getClosestEntity(animalEntities, TargetPredicate.DEFAULT, null, x, y, z);

            System.out.println("closestEntity = " + closestEntity);
            if (closestEntity != null && !closestEntity.isBaby()) {
                final ClientWorld world = MinecraftClient.getInstance().world;
                System.out.println("world = " + world);

                if (world != null) {
                    int range = 1;
                    for (int i = 0; i < 10; i++) {
                        double offsetX = (Math.random() - 0.5) * 2.0 * range;
                        double offsetY = (Math.random() - 0.5) * 2.0 * range;
                        double offsetZ = (Math.random() - 0.5) * 2.0 * range;

                        world.addParticle(
                                ParticleTypes.HEART,    // particle type
                                x + offsetX,            // x position with random offset
                                y + offsetY,            // y position with random offset
                                z + offsetZ,            // z position with random offset
                                0, 0, 0                // velocity offsets
                        );
                    }
                    closestEntity.lookAtEntity(player, 1, 1);

                    if (Math.random() > 0.9) {
                        AnimalEntity baby = (AnimalEntity) closestEntity.getType().create(closestEntity.world);
                        if (baby != null) {

                            baby.copyPositionAndRotation(closestEntity);
                            baby.setHeadYaw(baby.getMaxHealth());
                            baby.setBaby(true);
                            baby.setPersistent();
                            ;
                            closestEntity.world.spawnEntity(baby);
                            closestEntity.playAmbientSound();

                        }

                    }

                }
            }

        }

    }
}
