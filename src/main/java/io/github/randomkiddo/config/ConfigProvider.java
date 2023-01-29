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

import java.util.ArrayList;
import java.util.List;

/**
 * The config provider, implements <code>MainConfig.DefaultConfig</code>
 * @see MainConfig.DefaultConfig
 * @see MainConfig
 */
public class ConfigProvider implements MainConfig.DefaultConfig {
    /**
     * The config contents string
     */
    private String configContents = "";
    /**
     * The list of configs
     */
    private final List<Pair> configsList = new ArrayList<>();

    /**
     * Gets the config list
     * @return Returns the config list above
     */
    public List<Pair> getConfigsList() { return this.configsList; }

    /**
     * Adds a key-value pair to the configs list
     * @param keyValuePair The key-value pair to add
     * @param cmt A comment string
     */
    public void addKeyValuePair(Pair<String, ?> keyValuePair, String cmt) {
        this.configsList.add(keyValuePair);
        configContents += keyValuePair.getFirst() + "=" + keyValuePair.getSecond() + " #" +
                cmt + " | default: " + keyValuePair.getSecond() + "\n";
    }

    /**
     * Overrides the get method, gets the config contents String
     * @param ns The namespace string
     * @return The config contents String
     */
    @Override public String get(String ns) { return this.configContents; }
}
