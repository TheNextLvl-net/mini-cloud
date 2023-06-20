package minicloud.api.server;

import minicloud.api.object.Identifier;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ServerManager {
    /**
     * Get a list of all servers
     *
     * @return all servers
     */
    List<Server> getServers();

    /**
     * Get an existing server
     *
     * @param name the name of the desired server
     * @return the desired server
     */
    Optional<Server> getServer(Identifier name);

    /**
     * Start a server if it is offline
     *
     * @param server the server to start
     * @return a completable future completing when the server started or failed to start
     */
    CompletableFuture<Void> start(Identifier server);

    /**
     * Stop a server if it is running
     *
     * @param server the server to stop
     * @return a completable future completing when the server stopped or failed to stop
     */
    CompletableFuture<Void> stop(Identifier server);

    /**
     * Create a new server
     *
     * @param name  the name of the server
     * @param group the group the server will be associated with
     * @return the new server
     */
    Server createServer(Identifier name, Identifier group);

    /**
     * Remove an existing server
     *
     * @param server the server to remove
     */
    void removeServer(Identifier server);
}
