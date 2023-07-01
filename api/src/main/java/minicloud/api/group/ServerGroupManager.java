package minicloud.api.group;

import minicloud.api.object.Identifier;
import minicloud.api.server.Server;

import java.util.List;
import java.util.Optional;

public interface ServerGroupManager {
    /**
     * Get a list of all groups
     *
     * @return all groups
     */
    List<ServerGroup> getGroups();

    /**
     * Get a list of all servers associated with the given group
     *
     * @param group the group to get the servers from
     * @return all servers in the given group
     */
    List<Server> getServers(Identifier group);

    /**
     * Get an existing group
     *
     * @param name the name of the desired group
     * @return the desired group
     */
    Optional<ServerGroup> getGroup(Identifier name);

    /**
     * Create a new group
     *
     * @param group the name of the group
     * @return the new group
     */
    ServerGroup createGroup(ServerGroup group);

    /**
     * Remove an existing group
     *
     * @param group the group to remove
     */
    void removeGroup(Identifier group);
}
