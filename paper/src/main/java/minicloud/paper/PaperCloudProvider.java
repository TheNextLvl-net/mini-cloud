package minicloud.paper;

import core.api.file.format.GsonFile;
import minicloud.api.CloudProvider;
import minicloud.client.ClientCloudProvider;
import minicloud.paper.config.CloudConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class PaperCloudProvider extends JavaPlugin {
    private final CloudConfig config = new GsonFile<>(
            new File("plugins/MiniCloud/config.json"),
            new CloudConfig("http://0.0.0.0:8080")
    ) {{
        if (!getFile().exists()) save();
    }}.getRoot();

    @Override
    public void onEnable() {
        Bukkit.getServicesManager().register(
                CloudProvider.class,
                new ClientCloudProvider(config.daemonUrl()),
                this, ServicePriority.Highest
        );
    }
}
