package minicloud.api.server;

import org.intellij.lang.annotations.Pattern;

import java.net.http.HttpResponse;
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
    Optional<Server> getServer(@Pattern("^[a-zA-Z0-9_-]+$") String name);

    /**
     * Create a new server
     *
     * @param group the group the server will be associated with
     * @return the new server
     */
    Server createServer(@Pattern("^[a-zA-Z0-9_-]+$") String group);

    /**
     * Remove an existing server
     *
     * @param server the server to remove
     */
    void removeServer(@Pattern("^[a-zA-Z0-9_-]+$") String server);

    /**
     * Start the server if it is offline
     *
     * @param server the server to start
     * @return a completable future completing when the server started or failed to start
     */
    CompletableFuture<HttpResponse<Void>> start(@Pattern("^[a-zA-Z0-9_-]+$") String server);

    /**
     * Stop the server if it is running
     *
     * @param server the server to stop
     * @return a completable future completing when the server stopped or failed to stop
     */
    CompletableFuture<HttpResponse<Void>> stop(@Pattern("^[a-zA-Z0-9_-]+$") String server);
}
