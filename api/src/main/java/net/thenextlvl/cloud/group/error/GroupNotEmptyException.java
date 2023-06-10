package net.thenextlvl.cloud.group.error;

public class GroupNotEmptyException extends RuntimeException {
    public GroupNotEmptyException() {
    }

    public GroupNotEmptyException(String message) {
        super(message);
    }

    public GroupNotEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupNotEmptyException(Throwable cause) {
        super(cause);
    }
}
