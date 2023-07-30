package minicloud.api.event;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface EventManager {
    /**
     * registers an event handler that listens to
     * everything that happens on the server
     *
     * @param request the requested events
     * @param handler the event handler
     * @return returns the given future
     */
    CompletableFuture<HttpResponse<String>> addHandler(EventsRequest request, Consumer<EventMessage> handler);

    /**
     * unregisters an event handler
     *
     * @param request the requested events
     * @param handler the event handler
     */
    void removeHandler(EventsRequest request, Consumer<EventMessage> handler);
}
