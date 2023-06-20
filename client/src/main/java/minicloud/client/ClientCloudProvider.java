package minicloud.client;

import lombok.Getter;
import minicloud.api.CloudProvider;
import minicloud.api.group.ServerGroupManager;
import minicloud.api.server.ServerManager;
import minicloud.api.template.TemplateManager;
import minicloud.client.group.ClientGroupManager;
import minicloud.client.server.ClientServerManager;
import minicloud.client.template.ClientTemplateManager;

@Getter
public class ClientCloudProvider implements CloudProvider {
    private final ServerGroupManager groupManager = new ClientGroupManager();
    private final ServerManager serverManager = new ClientServerManager();
    private final TemplateManager templateManager = new ClientTemplateManager();
}
