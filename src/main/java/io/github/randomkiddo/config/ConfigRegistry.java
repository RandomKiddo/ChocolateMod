/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.config;

import com.mojang.datafixers.util.Pair;

import java.util.logging.LogManager;

public class ConfigRegistry {
    public static MainConfig CONFIG;
    private static ConfigProvider configs;
    public static boolean USING_FAST_GRAPHICS;
    public static void register() {
        LogManager.getLogManager().addLogger(MainConfig.LOGGER);
        configs = new ConfigProvider();
        configs.addKeyValuePair(new Pair<>("default.graphics.fast", false), "boolean");
        CONFIG = MainConfig.of("chocolateconfig").provider(configs).request();
        USING_FAST_GRAPHICS = CONFIG.getOrDefault("default.graphics.fast", false);
    }
}
