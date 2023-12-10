package minicloud.api.event;

import com.google.gson.annotations.SerializedName;
import org.intellij.lang.annotations.Pattern;

public record EventsRequest(
        @Pattern("^[a-zA-Z0-9_-]+$")
        @SerializedName("name") String name,
        @SerializedName("type") EventType type
) {
}
