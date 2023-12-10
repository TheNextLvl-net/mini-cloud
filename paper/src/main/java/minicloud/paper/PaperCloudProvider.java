package minicloud.paper;

import core.file.format.GsonFile;
import core.io.IO;
import minicloud.api.CloudProvider;
import minicloud.client.ClientCloudProvider;
import minicloud.paper.config.CloudConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class PaperCloudProvider extends JavaPlugin {
    private final CloudConfig config = new GsonFile<>(
            IO.of("plugins/MiniCloud/config.json"),
            new CloudConfig("http://0.0.0.0:8080")
    ).validate().saveIfAbsent().getRoot();

    @Override
    public void onEnable() {
        Bukkit.getServicesManager().register(
                CloudProvider.class,
                new ClientCloudProvider(config.daemonUrl()),
                this, ServicePriority.Highest
        );
    }
}
