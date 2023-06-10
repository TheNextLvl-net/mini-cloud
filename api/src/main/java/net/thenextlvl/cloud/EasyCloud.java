package net.thenextlvl.cloud;

import net.thenextlvl.cloud.group.GroupManager;
import net.thenextlvl.cloud.server.ServerManager;
import net.thenextlvl.cloud.template.TemplateManager;

public interface EasyCloud {
    /**
     * Get the group manager
     *
     * @return the group manager
     */
    GroupManager getGroupManager();

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
