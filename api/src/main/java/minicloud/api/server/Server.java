package minicloud.api.server;

import minicloud.api.group.ServerGroup;
import minicloud.api.object.Identifier;

import java.net.InetAddress;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public interface Server {
    /**
     * Get the name identifier of the server
     *
     * @return the name identifier
     */
    Identifier getName();

    /**
     * Get the associated group of the server
     *
     * @return the group
     */
    ServerGroup getGroup();

    /**
     * Get the group identifier of the server
     *
     * @return the group identifier
     */
    Identifier getGroupId();

    /**
     * Get the internet address of the server
     *
     * @return the internet address
     */
    InetAddress getAddress();

    /**
     * Get the status of the server
     *
     * @return the current server status
     */
    Status getStatus();

    /**
     * Get the player count of the server
     *
     * @return the current player count
     */
    int getOnlinePlayers();

    /**
     * Start the server if it is offline
     *
     * @return a completable future completing when the server started or failed to start
     */
    CompletableFuture<HttpResponse<Void>> start();

    /**
     * Stop the server if it is running
     *
     * @return a completable future completing when the server stopped or failed to stop
     */
    CompletableFuture<HttpResponse<Void>> stop();
}
