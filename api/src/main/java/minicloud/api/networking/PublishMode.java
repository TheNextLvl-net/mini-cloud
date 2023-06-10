package minicloud.api.networking;

import com.google.gson.annotations.SerializedName;

public enum PublishMode {
    @SerializedName("ingress") INGRESS,
    @SerializedName("host") HOST
}
