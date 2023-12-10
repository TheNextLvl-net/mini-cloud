package minicloud.client;

import lombok.Getter;
import minicloud.api.CloudProvider;
import minicloud.client.event.ClientEventManager;
import minicloud.client.group.ClientGroupManager;
import minicloud.client.server.ClientServerManager;
import minicloud.client.template.ClientTemplateManager;

@Getter
public class ClientCloudProvider implements CloudProvider {
    private final ClientGroupManager groupManager;
    private final ClientServerManager serverManager;
    private final ClientTemplateManager templateManager;
    private final ClientEventManager eventManager;

    private final String serverUrl;

    public ClientCloudProvider(String serverUrl) {
        this.serverUrl = serverUrl;
        this.groupManager = new ClientGroupManager(this);
        this.serverManager = new ClientServerManager(this);
        this.templateManager = new ClientTemplateManager(this);
        this.eventManager = new ClientEventManager(this);
    }
}
