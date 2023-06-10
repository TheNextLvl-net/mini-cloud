package net.thenextlvl.cloud.velocity.group;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.thenextlvl.cloud.group.Group;
import net.thenextlvl.cloud.server.Server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class VelocityGroup implements Group {
    private final List<Server> servers = new ArrayList<>();
    private final String name;
    private final File container;

    @Override
    public boolean isEmpty() {
        return servers.isEmpty();
    }
}
