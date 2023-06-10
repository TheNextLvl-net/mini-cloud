package net.thenextlvl.cloud.group;

import net.thenextlvl.cloud.group.error.GroupNotEmptyException;

import java.util.Collection;

public interface GroupManager {
    /**
     * Get a lis of all groups
     *
     * @return all groups
     */
    Collection<? extends Group> getGroups();

    /**
     * Create a new group
     *
     * @param name the name of the group
     * @return the new group
     */
    Group createGroup(String name);

    /**
     * Remove an existing group
     *
     * @param group the group to remove
     * @throws GroupNotEmptyException thrown if the group contains servers
     */
    void removeGroup(Group group) throws GroupNotEmptyException;
}
