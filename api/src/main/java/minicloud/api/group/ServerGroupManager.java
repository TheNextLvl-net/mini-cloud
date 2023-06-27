package minicloud.api.group;

import minicloud.api.object.Identifier;

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
