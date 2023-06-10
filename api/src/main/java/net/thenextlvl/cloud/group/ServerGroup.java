package net.thenextlvl.cloud.group;

import net.thenextlvl.cloud.object.IdentifiableObject;
import net.thenextlvl.cloud.networking.Port;
import net.thenextlvl.cloud.server.Server;
import net.thenextlvl.cloud.template.Template;

import java.util.Collection;

public interface ServerGroup extends IdentifiableObject {
    /**
     * Get the template the group is providing
     *
     * @return the template the group provides
     */
    Template getTemplate();

    /**
     * Get all ports this group can use
     *
     * @return a list of ports
     */
    Collection<? extends Port> getPorts();

    /**
     * Get all servers associated with this group
     *
     * @return a list of servers
     */
    Collection<? extends Server> getServers();

    /**
     * Get the max player count each server in this group can have
     *
     * @return the max player count per server
     */
    int getMaxPlayersPerServer();
}
