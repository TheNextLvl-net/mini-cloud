package minicloud.client.group;

import minicloud.api.group.ServerGroup;
import minicloud.api.networking.Port;
import minicloud.api.server.Server;
import minicloud.api.template.Template;

import java.util.List;

public class ClientServerGroup implements ServerGroup {
    @Override
    public Template getTemplate() {
        return null;
    }

    @Override
    public List<Port> getPorts() {
        return null;
    }

    @Override
    public List<Server> getServers() {
        /*
         GET /api/v1/group/{group}/servers
         200
            ServerList
         400
            Invalid input
         404
            Server group not found
         */
        return null;
    }

    @Override
    public int getMaxPlayersPerServer() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}
