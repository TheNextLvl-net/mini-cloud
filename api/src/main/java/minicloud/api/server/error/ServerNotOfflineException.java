package minicloud.api.server.error;

public class ServerNotOfflineException extends RuntimeException {
    public ServerNotOfflineException() {
    }

    public ServerNotOfflineException(String message) {
        super(message);
    }

    public ServerNotOfflineException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerNotOfflineException(Throwable cause) {
        super(cause);
    }
}
