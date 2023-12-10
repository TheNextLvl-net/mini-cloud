package minicloud.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;
import org.slf4j.Logger;

import java.nio.file.Path;

@Getter
@Plugin(
        id = "mini-cloud",
        name = "MiniCloud",
        version = "1.0.0",
        url = "https://thenextlvl.net",
        authors = {"NonSwag"}
)
public class MiniCloudPlugin {
    private final ProxyServer server;
    private final Logger logger;
    private final Path path;

    @Inject
    public MiniCloudPlugin(ProxyServer server, Logger logger, @DataDirectory Path path) {
        this.server = server;
        this.logger = logger;
        this.path = path;
    }
}
