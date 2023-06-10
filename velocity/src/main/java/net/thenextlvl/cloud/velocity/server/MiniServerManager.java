package net.thenextlvl.cloud.velocity.server;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.thenextlvl.cloud.server.Server;
import net.thenextlvl.cloud.server.ServerManager;
import net.thenextlvl.cloud.server.error.ServerNotOfflineException;
import net.thenextlvl.cloud.template.Template;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class MiniServerManager implements ServerManager {
    private final List<Server> servers = new ArrayList<>();
    private final File container;

    @Override
    public Server createServer(Template template, String name) {
        return null;
    }

    @Override
    public boolean removeServer(Server server) throws ServerNotOfflineException {
        if (server.getStatus().isOffline()) return servers.remove(server);
        throw new ServerNotOfflineException();
    }
}
