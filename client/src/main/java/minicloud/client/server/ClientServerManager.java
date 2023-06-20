package minicloud.client.server;

import minicloud.api.object.Identifier;
import minicloud.api.server.Server;
import minicloud.api.server.ServerManager;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ClientServerManager implements ServerManager {
    @Override
    public List<Server> getServers() {
        /*
        GET /api/v1/server
        200 -> array Server
         */
        return null;
    }

    @Override
    public Optional<Server> getServer(Identifier name) {
        /*
        GET /api/v1/server/{name}
        name -> Identifier
        200 -> Server
        400 -> Invalid input
        404 -> Server not found
         */
        return Optional.empty();
    }

    @Override
    public CompletableFuture<Void> start(Identifier server) {
        /*
        POST /api/v1/server/{name}/start
        name -> Identifier
        200 -> success
        400 -> Invalid input
        404 -> Server not found
         */
        return null;
    }

    @Override
    public CompletableFuture<Void> stop(Identifier server) {
        /*
        POST /api/v1/server/{name}/stop
        name -> Identifier
        200 -> success
        400 -> Invalid input
        404 -> Server not found
         */
        return null;
    }

    @Override
    public Server createServer(Identifier name, Identifier group) {
        /*
        POST /api/v1/server
        body
            name -> Identifier
            group -> Identifier
        201 -> Server
        400 -> Invalid input
        404 -> Server group not found
        409 -> Server already exists
         */
        return null;
    }

    @Override
    public void removeServer(Identifier server) {
        /*
        GET /api/v1/server/{name}
        name -> Identifier
        200 -> success
        400 -> Invalid input
        404 -> Server not found
         */
    }
}
