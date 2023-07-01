package minicloud.client.group;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.group.ServerGroup;
import minicloud.api.group.ServerGroupManager;
import minicloud.api.object.Identifier;
import minicloud.api.server.Server;
import minicloud.client.http.Requests;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class ClientGroupManager implements ServerGroupManager {
    private final String serverUrl;

    @Override
    public List<ServerGroup> getGroups() {
        try {
            var groups = Requests.<String>get(serverUrl + "/api/v1/group")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(groups, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Server> getServers(Identifier group) {
        try {
            var servers = Requests.<String>get(serverUrl + "/api/v1/group/" + group + "/servers")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(servers, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ServerGroup> getGroup(Identifier name) {
        try {
            var group = Requests.<String>get(serverUrl + "/api/v1/group/" + name)
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return Optional.ofNullable(new Gson().fromJson(group, new TypeToken<>() {
            }));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ServerGroup createGroup(ServerGroup group) {
        try {
            var response = Requests.<String>post(serverUrl + "/api/v1/group", HttpRequest.BodyPublishers.ofString(
                            new Gson().toJsonTree(this).toString(),
                            StandardCharsets.UTF_8))
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(response, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeGroup(Identifier group) {
        try {
            Requests.<Void>delete(serverUrl + "/api/v1/group/" + group)
                    .send(HttpResponse.BodyHandlers.discarding())
                    .body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
