package net.thenextlvl.cloud.group;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;

public interface GroupManager {
    /**
     * Get a list of all groups
     *
     * @return all groups
     */
    Collection<? extends ServerGroup> getGroups();

    /**
     * Get an existing group
     *
     * @param name the name of the desired group
     * @return the desired group
     */
    @Nullable Optional<ServerGroup> getGroup(String name);

    /**
     * Create a new group
     *
     * @param name the name of the group
     * @return the new group
     */
    ServerGroup createGroup(String name);

    /**
     * Remove an existing group
     *
     * @param group the group to remove
     */
    void removeGroup(ServerGroup group);
}
