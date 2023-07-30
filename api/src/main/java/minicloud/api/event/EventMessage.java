package minicloud.api.event;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;

public record EventMessage(
        @SerializedName("type") EventType type,
        @SerializedName("action") EventAction action,
        @SerializedName("time") DateFormat time,
        @SerializedName("object") JsonObject object
) {
}
