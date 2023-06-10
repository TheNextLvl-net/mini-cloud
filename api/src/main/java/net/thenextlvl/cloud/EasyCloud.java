package net.thenextlvl.cloud;

import net.thenextlvl.cloud.group.GroupManager;
import net.thenextlvl.cloud.server.ServerManager;
import net.thenextlvl.cloud.template.TemplateManager;

public interface EasyCloud {
    GroupManager getGroupManager();

    ServerManager getServerManager();

    TemplateManager getTemplateManager();
}
