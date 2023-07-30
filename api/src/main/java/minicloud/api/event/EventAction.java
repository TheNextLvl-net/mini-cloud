package minicloud.api.event;

import com.google.gson.annotations.SerializedName;

public enum EventAction {
    @SerializedName("create") CREATE,
    @SerializedName("remove") REMOVE,
    @SerializedName("update") UPDATE
}
