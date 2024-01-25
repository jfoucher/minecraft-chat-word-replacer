package fr.sixpixels.wordreplacer;

import com.google.common.base.Charsets;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public final class Main extends JavaPlugin {
    public List<ChatReplacement> chatReplacements = new ArrayList<>();
    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.loadConfig();
        Bukkit.getLogger().info("[WordReplacer] WordReplacer " + getDescription().getVersion() + " loaded");

        registerCommands();
    }

    public void loadConfig (){
        this.chatReplacements = new ArrayList<>();
        this.reloadConfig();
        ConfigurationSection config = Objects.requireNonNull(getConfig().getConfigurationSection("replacements"));
        Set<String> replacements = config.getKeys(false);

        for (String rep: replacements) {
            List<Map<?, ?>> vals  = config.getMapList(rep + ".replacements");

            List<ReplacementItem> possibilities = new ArrayList<>();
            for (Map<?, ?> val: vals) {
                Double chance = 0.0;
                try {
                    chance = (Double) val.get("chance");
                } catch (ClassCastException e) {
                    Integer ch = (Integer) val.get("chance");
                    chance = ch.doubleValue();
                }

                possibilities.add(new ReplacementItem((String) val.get("string"), chance));
            }

            this.chatReplacements.add(new ChatReplacement(rep, possibilities));
        }
        registerListeners();
        Bukkit.getLogger().info("[WordReplacer] " + this.chatReplacements.size() + " replacements loaded from config");
    }

    private void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ChatReplacer(this), this);
    }

    private void registerCommands(){
        this.getCommand("wordreplacer").setExecutor(new WordReplacerCommand(this));
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
