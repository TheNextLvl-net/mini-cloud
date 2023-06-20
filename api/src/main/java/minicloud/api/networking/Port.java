package minicloud.api.networking;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Port {
    private final @SerializedName("name") String name;
    private final @SerializedName("protocol") Protocol protocol;
    private final @SerializedName("target-port") int targetPort;
    private final @SerializedName("published-port") int publishedPort;
    private final @SerializedName("publish-mode") PublishMode publishMode;
}
