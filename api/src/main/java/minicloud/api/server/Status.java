package minicloud.api.server;

public enum Status {
    ONLINE, OFFLINE, STARTING;

    /**
     * @return whether the server is not offline
     */
    public boolean isRunning() {
        return !isOffline();
    }

    /**
     * @return whether the server is online
     */
    public boolean isOnline() {
        return equals(ONLINE);
    }

    /**
     * @return whether the server is starting
     */
    public boolean isStarting() {
        return equals(STARTING);
    }

    /**
     * @return whether the server is offline
     */
    public boolean isOffline() {
        return equals(OFFLINE);
    }
}
