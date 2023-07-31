package minicloud.api.event;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public record EventMessage(
        @SerializedName("type") EventType type,
        @SerializedName("action") EventAction action,
        @SerializedName("time") long time,
        @SerializedName("object") JsonObject object
) {
}
