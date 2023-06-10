package net.thenextlvl.cloud.server;

import net.thenextlvl.cloud.object.ContainerizedObject;
import net.thenextlvl.cloud.group.Group;
import net.thenextlvl.cloud.object.IdentifiableObject;
import net.thenextlvl.cloud.template.Template;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

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
     * @param started This will be called when the server is online or failed to start
     * @return whether the server will be started
     */
    boolean start(Consumer<Boolean> started);

    /**
     * Stop the server if it is running
     *
     * @param stopped This will be called when the server is offline or failed to stop
     * @return whether the server will be stopped
     */
    boolean stop(Consumer<Boolean> stopped);
}
