package minicloud.api.group;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.networking.Port;
import minicloud.api.object.Identifier;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ServerGroup {
    /**
     * Get the name identifier of the group
     */
    private final Identifier name;

    /**
     * Get the template identifier of the group
     */
    private final Identifier template;

    /**
     * Get all ports this group can use
     */
    private final List<Port> ports;

    /**
     * Get the max player count each server in this group can have
     */
    private final int maxPlayersPerServer;
}
