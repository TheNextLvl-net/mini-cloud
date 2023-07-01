package minicloud.client.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.object.Identifier;
import minicloud.api.server.Server;
import minicloud.api.server.ServerManager;
import minicloud.client.http.Requests;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Getter
@RequiredArgsConstructor
public class ClientServerManager implements ServerManager {
    private final String serverUrl;

    @Override
    public List<Server> getServers() {
        try {
            var servers = Requests.<String>get(serverUrl + "/api/v1/server")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(servers, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Server> getServer(Identifier name) {
        try {
            var server = Requests.<String>get(serverUrl + "/api/v1/server/" + name)
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return Optional.ofNullable(new Gson().fromJson(server, new TypeToken<>() {
            }));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Server createServer(Identifier name, Identifier group) {
        try {
            var server = Requests.<String>post(serverUrl + "/api/v1/server", HttpRequest.BodyPublishers.concat(
                            HttpRequest.BodyPublishers.ofString(name.toString(), StandardCharsets.UTF_8),
                            HttpRequest.BodyPublishers.ofString(group.toString(), StandardCharsets.UTF_8)))
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(server, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeServer(Identifier server) {
        try {
            Requests.<Void>delete(serverUrl + "/api/v1/server/" + server)
                    .send(HttpResponse.BodyHandlers.discarding())
                    .body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CompletableFuture<HttpResponse<Void>> start(Identifier server) {
        return Requests.<Void>post(serverUrl + "/api/v1/server/" + server + "/start",
                        HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofMinutes(5))
                .sendAsync(HttpResponse.BodyHandlers.discarding());
    }

    @Override
    public CompletableFuture<HttpResponse<Void>> stop(Identifier server) {
        return Requests.<Void>post(serverUrl + "/api/v1/server/" + server + "/stop",
                        HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofMinutes(5))
                .sendAsync(HttpResponse.BodyHandlers.discarding());
    }
}
