package minicloud.api.group;

import minicloud.api.networking.Port;
import minicloud.api.object.Identifier;
import minicloud.api.server.Server;
import minicloud.api.template.Template;

import java.util.List;

public interface ServerGroup {
    /**
     * Get the name identifier of the group
     *
     * @return the name identifier
     */
    Identifier getName();

    /**
     * Get the template the group is providing
     *
     * @return the template the group provides
     */
    Template getTemplate();

    /**
     * Get the template identifier of the group
     *
     * @return the template identifier
     */
    Identifier getTemplateId();

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
