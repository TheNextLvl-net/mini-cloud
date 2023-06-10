package net.thenextlvl.cloud.group;

import java.util.Collection;

public interface GroupManager {
    Collection<? extends Group> getGroups();

    Group createGroup();

    boolean removeGroup(Group group);
}
