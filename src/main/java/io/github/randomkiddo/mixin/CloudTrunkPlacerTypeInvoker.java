/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo
 */

package io.github.randomkiddo.mixin;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/**
 * Mixin that invokes the register method in the TrunkPlacerTypeClass. This helps with our custom generation
 * of cloud trees
 *
 * @see Mixin
 * @see Invoker
 * @see TrunkPlacerType
 */
@Mixin(TrunkPlacerType.class)
public interface CloudTrunkPlacerTypeInvoker {
    /**
     * Invokes the register method
     * @param id The id String
     * @param codec The Mojang Codec
     * @return Throws an IllegalStateException
     * @param <T> ? extends Object
     */
    @Invoker("register")
    static <T extends TrunkPlacer> TrunkPlacerType<T> callRegister(String id, Codec<T> codec) {
        throw new IllegalStateException();
    }
}
