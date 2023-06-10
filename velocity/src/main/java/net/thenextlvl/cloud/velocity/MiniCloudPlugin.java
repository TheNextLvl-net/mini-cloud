package net.thenextlvl.cloud.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;
import net.thenextlvl.cloud.CloudProvider;
import net.thenextlvl.cloud.group.GroupManager;
import net.thenextlvl.cloud.server.ServerManager;
import net.thenextlvl.cloud.template.TemplateManager;
import net.thenextlvl.cloud.velocity.group.MiniGroupManager;
import net.thenextlvl.cloud.velocity.server.MiniServerManager;
import net.thenextlvl.cloud.velocity.template.VelocityTemplateManager;
import org.slf4j.Logger;

import java.io.File;

@Getter
@Plugin(
        id = "mini-cloud",
        name = "Mini Cloud",
        version = "1.0.0",
        url = "https://thenextlvl.net",
        authors = {"NonSwag"}
)
public class MiniCloudPlugin implements CloudProvider {
    private final File container = new File("container");
    private final GroupManager groupManager = new MiniGroupManager(new File(container, "groups"));
    private final ServerManager serverManager = new MiniServerManager(groupManager.getContainer());
    private final TemplateManager templateManager = new VelocityTemplateManager(new File(container, "templates"));

    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public MiniCloudPlugin(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        // server.getEventManager().register(this, new PluginListener());
    }
}
