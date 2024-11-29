package brcomkassin.bankingsystem.utils;

import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public final class Config extends YamlConfiguration {

    private final File file;
    private final String name;
    private final JavaPlugin plugin;

    public Config(JavaPlugin plugin, String name) {
        this.plugin = plugin;
        this.name = name;
        file = new File(plugin.getDataFolder(), name);
    }

    public void saveConfig() throws Exception {
        try {
            save(file);
        } catch (Exception e) {
            throw new Exception("Houve um problema ao salvar a config");
        }

    }

    public void reloadConfig() throws Exception {
        try {
            load(file);
        } catch (Exception e) {
            throw new Exception("Houve um problema ao recarregar a config");
        }

    }

    public void saveAndReloadDefaultConfig() throws Exception {
        plugin.saveResource(name, false);
        reloadConfig();
    }
}
