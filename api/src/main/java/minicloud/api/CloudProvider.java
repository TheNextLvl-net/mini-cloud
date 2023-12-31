package minicloud.api;

import minicloud.api.event.EventManager;
import minicloud.api.group.ServerGroupManager;
import minicloud.api.server.ServerManager;
import minicloud.api.template.TemplateManager;

public interface CloudProvider {
    /**
     * Get the server url
     *
     * @return the server url
     */
    String getServerUrl();

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

    /**
     * Get the event manager
     *
     * @return the event manager
     */
    EventManager getEventManager();
}
