package minicloud.api.event;

import java.util.concurrent.Future;

public interface EventManager {
    /**
     * registers an event handler that listens to
     * everything that happens on the server
     *
     * @param request the requested events
     * @param handler the event handler
     */
    Future<Void> listen(EventsRequest request, EventHandler handler);

    @FunctionalInterface
    interface EventHandler {
        void handle(EventMessage message, Exception exception);
    }
}
