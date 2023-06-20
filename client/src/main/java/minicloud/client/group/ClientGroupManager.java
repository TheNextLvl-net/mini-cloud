package minicloud.client.group;

import minicloud.api.group.ServerGroupManager;
import minicloud.api.group.ServerGroup;
import minicloud.api.object.Identifier;
import minicloud.api.server.Server;

import java.util.List;
import java.util.Optional;

public class ClientGroupManager implements ServerGroupManager {
    @Override
    public List<ServerGroup> getGroups() {
        /*
         GET /api/v1/group
         200 -> array ServerGroup
        */
        return null;
    }

    @Override
    public List<Server> getServers(Identifier group) {
        /*
        GET /api/v1/group/{group}/servers
        group -> Identifier
        200 -> array Server
        400 -> Invalid input
        404 -> Server group not found
         */
        return null;
    }

    @Override
    public Optional<ServerGroup> getGroup(Identifier name) {
        /*
        GET /api/v1/group/{name}
        name -> Identifier
        200 -> success
        400 -> Invalid input
        404 -> Server group not found
         */
        return Optional.empty();
    }

    @Override
    public ServerGroup createGroup(ServerGroup group) {
        /*
        POST /api/v1/group
        body -> ServerGroup
        201 -> ServerGroup
        400 -> Invalid input
        409 -> Server group already exists
         */
        return null;
    }

    @Override
    public void removeGroup(Identifier group) {
        /*
        DELETE /api/v1/group/{name}
        name -> Identifier
        200 -> success
        400 -> Invalid input
        404 -> Server group not found
         */
    }
}
