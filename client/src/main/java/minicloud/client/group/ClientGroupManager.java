package minicloud.client.group;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.CloudProvider;
import minicloud.api.group.ServerGroup;
import minicloud.api.group.ServerGroupManager;
import minicloud.api.server.Server;
import minicloud.client.http.Requests;
import org.intellij.lang.annotations.Pattern;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class ClientGroupManager implements ServerGroupManager {
    private final CloudProvider provider;
    private final Gson gson = new Gson();

    @Override
    public List<ServerGroup> getGroups() {
        try {
            var groups = Requests.<String>get(provider.getServerUrl() + "/api/v1/group")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return gson.fromJson(groups, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Server> getServers(@Pattern("^[a-zA-Z0-9_-]+$") String group) {
        try {
            var servers = Requests.<String>get(provider.getServerUrl() + "/api/v1/group/" + group + "/servers")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return gson.fromJson(servers, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ServerGroup> getGroup(@Pattern("^[a-zA-Z0-9_-]+$") String name) {
        try {
            var group = Requests.<String>get(provider.getServerUrl() + "/api/v1/group/" + name)
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return Optional.ofNullable(gson.fromJson(group, new TypeToken<>() {
            }));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ServerGroup createGroup(ServerGroup group) {
        try {
            var response = Requests.<String>post(provider.getServerUrl() + "/api/v1/group", HttpRequest.BodyPublishers.ofString(
                            gson.toJsonTree(this).toString(),
                            StandardCharsets.UTF_8))
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return gson.fromJson(response, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeGroup(@Pattern("^[a-zA-Z0-9_-]+$") String group) {
        try {
            Requests.<Void>delete(provider.getServerUrl() + "/api/v1/group/" + group)
                    .send(HttpResponse.BodyHandlers.discarding())
                    .body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
