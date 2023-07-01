package minicloud.api.event;

import com.google.gson.annotations.SerializedName;
import minicloud.api.object.Identifier;

public record EventsRequest(
        @SerializedName("name") Identifier name,
        @SerializedName("type") EventType type
) {
}
