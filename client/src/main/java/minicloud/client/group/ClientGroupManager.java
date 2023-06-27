package minicloud.client.group;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.group.ServerGroup;
import minicloud.api.group.ServerGroupManager;
import minicloud.api.object.Identifier;
import minicloud.client.http.Requests;

import java.io.IOException;
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
            var groups = Requests.<String>get("/api/v1/group")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(groups, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ServerGroup> getGroup(Identifier name) {
        /*
        GET /api/v1/group/{name}
        name -> Identifier
        200 -> success
        400 -> Invalid input
        404 -> Server group not found
         */
        return Optional.empty();
    }

    @Override
    public ServerGroup createGroup(ServerGroup group) {
        /*
        POST /api/v1/group
        body -> ServerGroup
        201 -> ServerGroup
        400 -> Invalid input
        409 -> Server group already exists
         */
        return null;
    }

    @Override
    public void removeGroup(Identifier group) {
        /*
        DELETE /api/v1/group/{name}
        name -> Identifier
        200 -> success
        400 -> Invalid input
        404 -> Server group not found
         */
    }
}
