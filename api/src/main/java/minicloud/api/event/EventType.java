package minicloud.api.event;

import com.google.gson.annotations.SerializedName;

public enum EventType {
    @SerializedName("server") SERVER,
    @SerializedName("server-group") SERVER_GROUP,
    @SerializedName("template") TEMPLATE
}
