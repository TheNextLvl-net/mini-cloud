package minicloud.api.group;

import minicloud.api.networking.Port;
import minicloud.api.object.IdentifiableObject;
import minicloud.api.template.Template;
import minicloud.api.server.Server;

import java.util.List;

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
    List<Port> getPorts();

    /**
     * Get all servers associated with this group
     *
     * @return a list of servers
     */
    List<Server> getServers();

    /**
     * Get the max player count each server in this group can have
     *
     * @return the max player count per server
     */
    int getMaxPlayersPerServer();
}
