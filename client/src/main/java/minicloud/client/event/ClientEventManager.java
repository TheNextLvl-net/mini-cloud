package minicloud.client.event;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.CloudProvider;
import minicloud.api.event.EventManager;
import minicloud.api.event.EventMessage;
import minicloud.api.event.EventsRequest;
import minicloud.client.http.Requests;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@Getter
@RequiredArgsConstructor
public class ClientEventManager implements EventManager {
    private final CloudProvider provider;
    private final Gson gson = new Gson();

    @Override
    public Future<Void> listen(EventsRequest request, EventHandler handler) {
        var future = new FutureTask<Void>(() -> {
            try {
                var json = gson.toJson(request);

                System.out.println(json);

                var response = Requests.<InputStream>post(provider.getServerUrl() + "/api/v1/events",
                                HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                        .send(HttpResponse.BodyHandlers.ofInputStream());

                System.out.println(response.statusCode());

                var gson = new Gson();
                var reader = new JsonReader(new InputStreamReader(response.body()));
                reader.setLenient(true);

                while (reader.hasNext()) {
                    handler.handle(gson.fromJson(reader, EventMessage.class), null);
                }
            } catch (InterruptedException ignored) {
            } catch (Exception e) {
                handler.handle(null, e);
            }
        }, null);
        new Thread(future).start();
        return future;
    }
}
