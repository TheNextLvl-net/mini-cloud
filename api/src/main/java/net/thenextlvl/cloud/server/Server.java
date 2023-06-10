package net.thenextlvl.cloud.server;

import net.thenextlvl.cloud.object.IdentifiableObject;

import java.net.InetAddress;
import java.util.concurrent.CompletableFuture;

public interface Server extends IdentifiableObject {
    /**
     * Get the associated group of the server
     *
     * @return the group
     */
    String getGroup();

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
     * @return a completable future indicating whether the server started
     */
    CompletableFuture<Void> start();

    /**
     * Stop the server if it is running
     *
     * @return a completable future indicating whether the server stopped
     */
    CompletableFuture<Void> stop();
}
