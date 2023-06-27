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
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class ClientServerManager implements ServerManager {
    private final String serverUrl;

    @Override
    public List<Server> getServers() {
        try {
            var servers = Requests.<String>get("/api/v1/server")
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
        /*
        GET /api/v1/server/{name}
        name -> Identifier
        200 -> Server
        400 -> Invalid input
        404 -> Server not found
         */
        return Optional.empty();
    }

    @Override
    public Server createServer(Identifier name, Identifier group) {
        /*
        POST /api/v1/server
        body
            name -> Identifier
            group -> Identifier
        201 -> Server
        400 -> Invalid input
        404 -> Server group not found
        409 -> Server already exists
         */
        return null;
    }

    @Override
    public void removeServer(Identifier server) {
        /*
        GET /api/v1/server/{name}
        name -> Identifier
        200 -> success
        400 -> Invalid input
        404 -> Server not found
         */
    }
}
