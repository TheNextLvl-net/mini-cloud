package minicloud.api.server;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.object.Identifier;

import java.net.InetAddress;

@Getter
@RequiredArgsConstructor
public class Server {
    /**
     * Get the name identifier of the server
     */
    private final Identifier name;

    /**
     * Get the group identifier of the server
     */
    private final Identifier group;

    /**
     * Get the internet address of the server
     */
    private final InetAddress address;

    /**
     * Get the status of the server
     */
    private final Status status;

    /**
     * Get the player count of the server
     */
    private final int onlinePlayers;
}
