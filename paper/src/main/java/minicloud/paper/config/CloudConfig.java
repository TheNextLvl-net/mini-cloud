package minicloud.paper.config;

import com.google.gson.annotations.SerializedName;

public record CloudConfig(
        @SerializedName("daemon-url") String daemonUrl
) {
}
