package minicloud.api.networking;

import com.google.gson.annotations.SerializedName;

public enum Protocol {
    @SerializedName("tcp") TCP,
    @SerializedName("udp") UDP,
    @SerializedName("sctp") SCTP
}
