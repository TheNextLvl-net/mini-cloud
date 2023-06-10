package net.thenextlvl.cloud.velocity.server;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.thenextlvl.cloud.group.Group;
import net.thenextlvl.cloud.server.Server;
import net.thenextlvl.cloud.server.ServerConfiguration;
import net.thenextlvl.cloud.server.Status;
import net.thenextlvl.cloud.template.Template;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.concurrent.CompletableFuture;

@Getter
@Setter
@RequiredArgsConstructor
public class MiniServer implements Server {
    private final String name;
    private final File container;
    private final ServerConfiguration configuration;
    private final @Nullable Template template;
    private @Nullable Group group;
    private Status status;
    private int onlinePlayers;
    private int maxPlayers;

    @Override
    public CompletableFuture<Boolean> start() {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> stop() {
        return null;
    }
}
