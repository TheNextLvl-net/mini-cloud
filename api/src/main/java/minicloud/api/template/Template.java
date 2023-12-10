package minicloud.api.template;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.intellij.lang.annotations.Pattern;

import java.text.DateFormat;

@Getter
@RequiredArgsConstructor
public class Template {
    /**
     * Get the name identifier of the template
     */
    @Pattern("^[a-zA-Z0-9_-]+$")
    private final String name;

    /**
     * Get the date when the template was created
     */
    private final DateFormat createdAt;

    /**
     * Get the date when the template was last updated
     */
    private final DateFormat updatedAt;

    /**
     * Get the size of the template in bytes
     */
    private final int size;
}
