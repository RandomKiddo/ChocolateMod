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

/**
 * The MainConfig class handles the mod config file
 */
public class MainConfig {
    /**
     * Initializes a logger that tracks what's happening with the config files
     */
    public static final Logger LOGGER = Logger.getLogger("MainConfig");
    /**
     * The config map
     */
    private final HashMap<String, String> config = new HashMap<>();
    /**
     * The config request instance
     */
    private final ConfigRequest request;
    /**
     * Holds if the config is broken
     */
    private boolean broken = false;

    /**
     * Interface holding default config specifications
     * @see ConfigProvider
     */
    public interface DefaultConfig {
        /**
         * Get a config
         * @param ns Namespace String
         * @return The String return value
         */
        String get(String ns);

        /**
         * Returns an empty String
         * @param ns Namespace String
         * @return Empty String ""
         */
        static String empty(String ns) { return ""; }
    }

    /**
     * Config Request class
     */
    public static class ConfigRequest {
        /**
         * The config file
         */
        private final File file;
        /**
         * The config filename
         */
        private final String fn;
        /**
         * The config provider (default)
         */
        private DefaultConfig provider;

        /**
         * Instantiates a new ConfigRequest
         * @param file The file instance
         * @param filename The filename
         */
        private ConfigRequest(File file, String filename) {
            this.file = file;
            this.fn = filename;
            this.provider = DefaultConfig::empty;
        }

        /**
         * Reuturns a ConfigRequest provider from a DefaultConfig
         * @param provider The DefaultConfig instance
         * @return A Config Request instance
         */
        public ConfigRequest provider(DefaultConfig provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Request a MainConfig
         * @return A MainConfig from a ConfigRequest
         */
        public MainConfig request() { return new MainConfig(this); }

        /**
         * Get the config string
         * @return The String from the filename
         */
        private String getConfig() { return this.provider.get(this.fn) + "\n"; }
    }

    /**
     * Create a ConfigRequest for a given filename
     * @param fn The filename
     * @return A ConfigRequest instance
     */
    public static ConfigRequest of(String fn) {
        Path path = FabricLoader.getInstance().getConfigDir();
        return new ConfigRequest(path.resolve(fn+".properties").toFile(), fn);
    }

    /**
     * Create the config
     * @throws IOException Thrown when there is a file manipulation error
     */
    private void createConfig() throws IOException {
        this.request.file.getParentFile().mkdirs();
        Files.createFile(this.request.file.toPath());
        PrintWriter writer = new PrintWriter(this.request.file, StandardCharsets.UTF_8);
        writer.write(this.request.getConfig());
        writer.close();
    }

    /**
     * Load the configs
     * @throws IOException Thrown when there is a file manipulation error
     */
    private void loadConfig() throws IOException {
        Scanner reader = new Scanner(this.request.file);
        for (int i = 1; reader.hasNextLine(); ++i) {
            this.parseConfigEntry(reader.nextLine(), i);
        }
    }

    /**
     * Parse the given config entry
     * @param entry The entry String
     * @param i The line number
     */
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

    /**
     * Constructs a MainConfig instance
     * @param request The ConfigRequest instance to use
     */
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

    /**
     * Deprecated; Returns the config value for the given key
     * @param key The key
     * @return The config value
     */
    @Deprecated public String get(String key) { return this.config.get(key); }

    /**
     * Gets the config value for the given key, or the default if null
     * @param key The key
     * @param def The default value to use if needed
     * @return The config value or the default value
     */
    public String getOrDefault(String key, String def) {
        String val = this.get(key);
        return val == null ? def : val;
    }

    /**
     * Gets the config value for the given key, or the default if null
     * @param key The key
     * @param def The default value to use if needed
     * @return The config value or the default value
     */
    public int getOrDefault(String key, int def) {
        try {
            return Integer.parseInt(this.get(key));
        } catch (Exception err) {
            return def;
        }
    }
    /**
     * Gets the config value for the given key, or the default if null
     * @param key The key
     * @param def The default value to use if needed
     * @return The config value or the default value
     */
    public boolean getOrDefault(String key, boolean def) {
        String val = this.get(key);
        if (val != null) {
            return val.equalsIgnoreCase("true");
        }
        return def;
    }
    /**
     * Gets the config value for the given key, or the default if null
     * @param key The key
     * @param def The default value to use if needed
     * @return The config value or the default value
     */
    public double getOrDefault(String key, double def) {
        try {
            return Double.parseDouble(this.get(key));
        } catch (Exception err) {
            return def;
        }
    }

    /**
     * Checks if the config is broken
     * @return true if broken, false otherwise
     */
    public boolean isBroken() { return broken; }

    /**
     * Deletes the config file
     * @return true if the file was deleted successfully, false otherwise
     */
    public boolean delete() {
        LOGGER.log(Level.WARNING, "Config '" + this.request.fn + "' was deleted. Game must be restarted to re-generate.");
        return this.request.file.delete();
    }
}
