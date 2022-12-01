package io.github.randomkiddo.enchants;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnchantmentRegistry {
    public static void register() {
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "adrenaline"),
                new AdrenalineEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "lightweight"),
                new LightweightEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "wince"),
                new WinceEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "aqua_aspect"),
                new AquaAspectEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "vampire"),
                new VampireEnchantment()
        );
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("chocolate", "experience"),
                new ExperienceEnchantment()
        );
    }
}
