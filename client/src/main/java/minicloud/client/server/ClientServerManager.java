package minicloud.client.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.CloudProvider;
import minicloud.api.server.Server;
import minicloud.api.server.ServerManager;
import minicloud.client.http.Requests;
import org.intellij.lang.annotations.Pattern;

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
    private final CloudProvider provider;
    private final Gson gson = new Gson();

    @Override
    public List<Server> getServers() {
        try {
            var servers = Requests.<String>get(provider.getServerUrl() + "/api/v1/server")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return gson.fromJson(servers, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Server> getServer(@Pattern("^[a-zA-Z0-9_-]+$") String name) {
        try {
            var server = Requests.<String>get(provider.getServerUrl() + "/api/v1/server/" + name)
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return Optional.ofNullable(gson.fromJson(server, new TypeToken<>() {
            }));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Server createServer(@Pattern("^[a-zA-Z0-9_-]+$") String group) {
        try {
            var server = Requests.<String>post(provider.getServerUrl() + "/api/v1/server",
                            HttpRequest.BodyPublishers.ofString(group, StandardCharsets.UTF_8))
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return gson.fromJson(server, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeServer(@Pattern("^[a-zA-Z0-9_-]+$") String server) {
        try {
            Requests.<Void>delete(provider.getServerUrl() + "/api/v1/server/" + server)
                    .send(HttpResponse.BodyHandlers.discarding())
                    .body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CompletableFuture<HttpResponse<Void>> start(@Pattern("^[a-zA-Z0-9_-]+$") String server) {
        return Requests.<Void>post(provider.getServerUrl() + "/api/v1/server/" + server + "/start",
                        HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofMinutes(5))
                .sendAsync(HttpResponse.BodyHandlers.discarding());
    }

    @Override
    public CompletableFuture<HttpResponse<Void>> stop(@Pattern("^[a-zA-Z0-9_-]+$") String server) {
        return Requests.<Void>post(provider.getServerUrl() + "/api/v1/server/" + server + "/stop",
                        HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofMinutes(5))
                .sendAsync(HttpResponse.BodyHandlers.discarding());
    }
}
