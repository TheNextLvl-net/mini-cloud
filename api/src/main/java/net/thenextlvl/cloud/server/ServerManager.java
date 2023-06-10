package net.thenextlvl.cloud.server;

import net.thenextlvl.cloud.server.error.ServerNotOfflineException;
import net.thenextlvl.cloud.template.Template;

import java.io.File;
import java.util.Collection;

public interface ServerManager {
    /**
     * Get the folder where all servers are stored
     *
     * @return the server container file
     */
    File getServerContainer();

    /**
     * Get a list of all servers
     *
     * @return all servers
     */
    Collection<? extends Server> getServers();

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
