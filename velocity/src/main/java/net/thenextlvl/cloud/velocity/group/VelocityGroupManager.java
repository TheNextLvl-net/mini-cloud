package net.thenextlvl.cloud.velocity.group;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.thenextlvl.cloud.group.Group;
import net.thenextlvl.cloud.group.GroupManager;
import net.thenextlvl.cloud.group.error.GroupNotEmptyException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class VelocityGroupManager implements GroupManager {
    private final List<Group> groups = new ArrayList<>();
    private final File container;

    @Override
    public Group createGroup(String name) {
        var group = new VelocityGroup(name, new File(getContainer(), name));
        groups.add(group);
        return group;
    }

    @Override
    public void removeGroup(Group group) throws GroupNotEmptyException {
        if (group.isEmpty()) groups.remove(group);
        throw new GroupNotEmptyException();
    }
}
