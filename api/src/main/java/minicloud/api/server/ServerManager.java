package minicloud.api.server;

import minicloud.api.server.error.ServerNotOfflineException;
import minicloud.api.template.Template;

import java.util.List;
import java.util.Optional;

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
    Optional<Server> getServer(String name);

    /**
     * Create a new server
     *
     * @param name     the name of the server
     * @param template the template to create the server from
     * @return the new server
     */
    Server createServer(Template template, String name);

    /**
     * Remove an existing server
     *
     * @param server the server to remove
     * @return whether the server's files could be removed
     * @throws ServerNotOfflineException thrown when the server is not offline
     */
    boolean removeServer(Server server) throws ServerNotOfflineException;
}
