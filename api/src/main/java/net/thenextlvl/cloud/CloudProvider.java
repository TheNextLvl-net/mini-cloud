package net.thenextlvl.cloud;

import net.thenextlvl.cloud.group.GroupManager;
import net.thenextlvl.cloud.object.ContainerizedObject;
import net.thenextlvl.cloud.server.ServerManager;
import net.thenextlvl.cloud.template.TemplateManager;

import java.io.File;

public interface CloudProvider extends ContainerizedObject {

    /**
     * Get the general folder where objects are stored
     *
     * @return the general object container file
     */
    @Override
    File getContainer();

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
