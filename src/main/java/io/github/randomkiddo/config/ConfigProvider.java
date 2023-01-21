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

public class ConfigProvider implements MainConfig.DefaultConfig {
    private String configContents = "";
    private final List<Pair> configsList = new ArrayList<>();
    public List<Pair> getConfigsList() { return this.configsList; }
    public void addKeyValuePair(Pair<String, ?> keyValuePair, String cmt) {
        this.configsList.add(keyValuePair);
        configContents += keyValuePair.getFirst() + "=" + keyValuePair.getSecond() + " #" +
                cmt + " | default: " + keyValuePair.getSecond() + "\n";
    }
    @Override public String get(String ns) { return this.configContents; }
}
