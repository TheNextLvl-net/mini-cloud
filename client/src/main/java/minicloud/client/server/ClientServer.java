package minicloud.client.server;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.group.ServerGroup;
import minicloud.api.object.Identifier;
import minicloud.api.server.Server;
import minicloud.api.server.Status;
import minicloud.client.http.Requests;

import java.net.InetAddress;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

@Getter
@RequiredArgsConstructor
public class ClientServer implements Server {
    private final Identifier name;
    private final Identifier groupId;

    private final ServerGroup group;
    private final InetAddress address;
    private final Status status;
    private final int onlinePlayers;

    @Override
    public CompletableFuture<HttpResponse<Void>> start() {
        return Requests.<Void>post("/api/v1/server/" + getName() + "/start",
                        HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofMinutes(5))
                .sendAsync(HttpResponse.BodyHandlers.discarding());
    }

    @Override
    public CompletableFuture<HttpResponse<Void>> stop() {
        return Requests.<Void>post("/api/v1/server/" + getName() + "/stop",
                        HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofMinutes(5))
                .sendAsync(HttpResponse.BodyHandlers.discarding());
    }
}
