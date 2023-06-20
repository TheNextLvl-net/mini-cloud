package minicloud.api;

import minicloud.api.group.ServerGroupManager;
import minicloud.api.server.ServerManager;
import minicloud.api.template.TemplateManager;

public interface CloudProvider {
    /**
     * Get the group manager
     *
     * @return the group manager
     */
    ServerGroupManager getGroupManager();

    /**
     * Get the server manager
     *
     * @return the server manager
     */
    ServerManager getServerManager();

    /**
     * Get the template manager
     *
     * @return the template manager
     */
    TemplateManager getTemplateManager();
}
