/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.commands;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.TypeFilter;

import java.util.List;

/**
 * Registers all commands (server and client)
 */
public class CommandRegistry {
    /**
     * Registers all the client and server commands below
     * @see CommandRegistrationCallback
     * @see ClientCommandRegistrationCallback
     */
    public static void register() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("iclear").requires(source -> source.hasPermissionLevel(4)).executes(ctx -> {
                int[] arr = CommandRegistry.clearServer(ctx.getSource().getWorld());
                ctx.getSource().sendMessage(Text.literal("Cleared " + arr[0] + " fallen entities of " + arr[1]));
                return 0;
            }));
        })); //Registers the server side iclear command
        ClientCommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("iclear").requires(source -> source.hasPermissionLevel(4)).executes(ctx -> {
                int[] arr = CommandRegistry.clearClient(ctx.getSource().getWorld());
                if (ctx.getSource().getEntity() != null) {
                    ctx.getSource().getEntity().sendMessage(Text.literal("Cleared " + arr[0] + " fallen entities of " + arr[1]));
                }
                return 0;
            })); //Registers the client side iclear command
        }));
    }

    /**
     * Clears the fallen entities on the server
     * @param serverWorld The server world instance
     * @return An int[] containing the amount cleared and the total entities loaded
     */
    public static int[] clearServer(ServerWorld serverWorld) {
        List<? extends ItemEntity> list = serverWorld.getEntitiesByType(TypeFilter.instanceOf(ItemEntity.class), EntityPredicates.VALID_ENTITY);
        int counter = 0;
        for (ItemEntity entity : list) {
            if (entity.isOnGround()) {
                entity.remove(Entity.RemovalReason.DISCARDED);
                ++counter;
            }
        }
        return new int[]{ counter, list.size() };
    }

    /**
     * Clears the fallen entities on the client
     * @param clientWorld The client world instance
     * @return An int[] containing the amount cleared and the total entities loaded
     */
    public static int[] clearClient(ClientWorld clientWorld) {
        Iterable<? extends Entity> list = clientWorld.getEntities();
        int counter = 0;
        int size = 0;
        for (Entity entity : list) {
            if (entity instanceof ItemEntity item && item.isOnGround()) {
                entity.remove(Entity.RemovalReason.DISCARDED);
                ++counter;
            }
            ++size;
        }
        return new int[]{ counter, size };
    }
}
