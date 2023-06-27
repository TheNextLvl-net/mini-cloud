package minicloud.client.group;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.group.ServerGroup;
import minicloud.api.networking.Port;
import minicloud.api.object.Identifier;
import minicloud.api.server.Server;
import minicloud.api.template.Template;
import minicloud.client.http.Requests;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ClientServerGroup implements ServerGroup {
    private final Identifier name;
    private final Identifier templateId;

    private final Template template;
    private final List<Port> ports;
    private final int maxPlayersPerServer;

    @Override
    public List<Server> getServers() {
        try {
            var servers = Requests.<String>get("/api/v1/group/" + getName() + "/servers")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(servers, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
