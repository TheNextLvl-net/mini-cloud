package minicloud.api.group;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.networking.Port;
import org.intellij.lang.annotations.Pattern;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ServerGroup {
    /**
     * Get the name identifier of the group
     */
    @Pattern("^[a-zA-Z0-9_-]+$")
    private final String name;

    /**
     * Get the template identifier of the group
     */
    @Pattern("^[a-zA-Z0-9_-]+$")
    private final String template;

    /**
     * Get all ports this group can use
     */
    private final List<Port> ports;

    /**
     * Get the max player count each server in this group can have
     */
    private final int maxPlayersPerServer;
}
