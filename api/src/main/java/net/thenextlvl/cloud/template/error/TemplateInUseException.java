package net.thenextlvl.cloud.template.error;

public class TemplateInUseException extends RuntimeException {
    public TemplateInUseException() {
    }

    public TemplateInUseException(String message) {
        super(message);
    }

    public TemplateInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public TemplateInUseException(Throwable cause) {
        super(cause);
    }
}
