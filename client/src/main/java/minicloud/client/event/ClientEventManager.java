package minicloud.client.event;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.event.EventManager;
import minicloud.api.event.EventMessage;
import minicloud.api.event.EventsRequest;
import minicloud.client.http.Requests;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@Getter
@RequiredArgsConstructor
public class ClientEventManager implements EventManager {
    private final Map<Map.Entry<EventsRequest, Consumer<EventMessage>>, CompletableFuture<HttpResponse<String>>> handlers = new HashMap<>();
    private final String serverUrl;

    @Override
    public CompletableFuture<HttpResponse<String>> addHandler(EventsRequest request, Consumer<EventMessage> handler) {
        var future = Requests.<String>post(serverUrl + "/api/v1/events",
                        HttpRequest.BodyPublishers.ofString(new Gson().toJson(request), StandardCharsets.UTF_8))
                .sendAsync(HttpResponse.BodyHandlers.ofString());
        future.thenAccept(response -> handler.accept(new Gson().fromJson(response.body(), EventMessage.class)));
        future.exceptionally(throwable -> {
            throwable.printStackTrace();
            return null;
        });
        handlers.put(Map.entry(request, handler), future);
        return future;
    }

    @Override
    public void removeHandler(EventsRequest request, Consumer<EventMessage> handler) {
        var entry = Map.entry(request, handler);
        if (!handlers.containsKey(entry)) return;
        handlers.get(entry).cancel(true);
        handlers.remove(entry);
    }
}
