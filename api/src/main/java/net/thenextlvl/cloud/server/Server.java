package net.thenextlvl.cloud.server;

import net.thenextlvl.cloud.group.Group;
import net.thenextlvl.cloud.object.ContainerizedObject;
import net.thenextlvl.cloud.object.IdentifiableObject;
import net.thenextlvl.cloud.template.Template;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public interface Server extends ContainerizedObject, IdentifiableObject {
    /**
     * Get the template the server is using
     *
     * @return the template the server is using
     */
    @Nullable Template getTemplate();

    /**
     * Get the associated group of the server
     *
     * @return the group the server is associated with
     */
    @Nullable Group getGroup();

    /**
     * Get the server's configuration
     *
     * @return the server's configuration
     */
    ServerConfiguration getConfiguration();

    /**
     * Set the group the server should be associated with
     *
     * @param group the group the server should be associated with
     */
    void setGroup(@Nullable Group group);

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
     * Get the max player count of the server
     *
     * @return the max player count
     */
    int getMaxPlayers();

    /**
     * Start the server if it is offline
     *
     * @return a completable future indicating whether the server started
     */
    CompletableFuture<Boolean> start();

    /**
     * Stop the server if it is running
     *
     * @return a completable future indicating whether the server stopped
     */
    CompletableFuture<Boolean> stop();
}
