package minicloud.api.object;

import java.util.regex.Pattern;

public interface IdentifiableObject {
    /**
     * The allowed pattern for names
     */
    Pattern NAMING_PATTERN = Pattern.compile("^[a-zA-Z0-9-_]+$");

    /**
     * Get the name of the object<br>
     *
     * @return the name of the object
     */
    String getName();
}
