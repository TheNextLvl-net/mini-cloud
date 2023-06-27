package minicloud.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.CloudProvider;
import minicloud.client.group.ClientGroupManager;
import minicloud.client.server.ClientServerManager;
import minicloud.client.template.ClientTemplateManager;

@Getter
@RequiredArgsConstructor
public class ClientCloudProvider implements CloudProvider {
    private final ClientGroupManager groupManager;
    private final ClientServerManager serverManager;
    private final ClientTemplateManager templateManager;

    private final String serverUrl;

    public ClientCloudProvider(String serverUrl) {
        this.groupManager = new ClientGroupManager(serverUrl);
        this.serverManager = new ClientServerManager(serverUrl);
        this.templateManager = new ClientTemplateManager(serverUrl);
        this.serverUrl = serverUrl;
    }
}
