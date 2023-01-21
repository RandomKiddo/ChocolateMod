/**
 * The Chocolate mod, repository, and source code is licensed under the GNU GPLv3 License
 * For more information, see: https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Copyright © 2021 RandomKiddo
 * Copyright © 2022 RandomKiddo, danield33
 * Copyright © 2023 RandomKiddo, danield33, NithilB, pranavmoola, Mag1cmang0
 */

package io.github.randomkiddo.config;

import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainConfig {
    public static final Logger LOGGER = Logger.getLogger("MainConfig");
    private final HashMap<String, String> config = new HashMap<>();
    private final ConfigRequest request;
    private boolean broken = false;
    public interface DefaultConfig {
        String get(String ns);
        static String empty(String ns) { return ""; }
    }
    public static class ConfigRequest {
        private final File file;
        private final String fn;
        private DefaultConfig provider;
        private ConfigRequest(File file, String filename) {
            this.file = file;
            this.fn = filename;
            this.provider = DefaultConfig::empty;
        }
        public ConfigRequest provider(DefaultConfig provider) {
            this.provider = provider;
            return this;
        }
        public MainConfig request() { return new MainConfig(this); }
        private String getConfig() { return this.provider.get(this.fn) + "\n"; }
    }
    public static ConfigRequest of(String fn) {
        Path path = FabricLoader.getInstance().getConfigDir();
        return new ConfigRequest(path.resolve(fn+".properties").toFile(), fn);
    }
    private void createConfig() throws IOException {
        this.request.file.getParentFile().mkdirs();
        Files.createFile(this.request.file.toPath());
        PrintWriter writer = new PrintWriter(this.request.file, StandardCharsets.UTF_8);
        writer.write(this.request.getConfig());
        writer.close();
    }
    private void loadConfig() throws IOException {
        Scanner reader = new Scanner(this.request.file);
        for (int i = 1; reader.hasNextLine(); ++i) {
            this.parseConfigEntry(reader.nextLine(), i);
        }
    }
    private void parseConfigEntry(String entry, int i) {
        if(!entry.isEmpty() && !entry.startsWith("#")) {
            String[] parts = entry.split("=", 2);
            if (parts.length == 2) {
                String temp = parts[1].split(" #")[0];
                this.config.put(parts[0], temp);
            } else {
                throw new RuntimeException("Syntax error in config file; Found on line " + i);
            }
        }
    }
    private MainConfig(ConfigRequest request) {
        this.request = request;
        String identifier = "Config '" + this.request.fn + "'";
        if (!this.request.file.exists()) {
            LOGGER.info(identifier + "is missing, using default one...");
            try {
                this.createConfig();
            } catch (IOException ioerr) {
                LOGGER.log(Level.SEVERE, identifier + " failed to generate properly!");
                LOGGER.log(Level.SEVERE, ioerr.toString());
                this.broken = true;
            }
        }
        if (!this.broken) {
            try {
                this.loadConfig();
            } catch (IOException ioerr) {
                LOGGER.log(Level.SEVERE, identifier + " failed to load!");
                LOGGER.log(Level.SEVERE, ioerr.toString());
                this.broken = true;
            }
        }
    }
    @Deprecated public String get(String key) { return this.config.get(key); }
    public String getOrDefault(String key, String def) {
        String val = this.get(key);
        return val == null ? def : val;
    }
    public int getOrDefault(String key, int def) {
        try {
            return Integer.parseInt(this.get(key));
        } catch (Exception err) {
            return def;
        }
    }
    public boolean getOrDefault(String key, boolean def) {
        String val = this.get(key);
        if (val != null) {
            return val.equalsIgnoreCase("true");
        }
        return def;
    }
    public double getOrDefault(String key, double def) {
        try {
            return Double.parseDouble(this.get(key));
        } catch (Exception err) {
            return def;
        }
    }
    public boolean isBroken() { return broken; }
    public boolean delete() {
        LOGGER.log(Level.WARNING, "Config '" + this.request.fn + "' was deleted. Game must be restarted to re-generate.");
        return this.request.file.delete();
    }
}
