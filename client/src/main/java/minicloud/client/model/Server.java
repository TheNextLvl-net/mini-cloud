package minicloud.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Server
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T02:15:12.085392277+02:00[Europe/Berlin]")

public class Server {
    @JsonProperty("name")
    private String name;

    @JsonProperty("group")
    private String group;

    @JsonProperty("ip-address")
    private String ipAddress;
    @JsonProperty("status")
    private StatusEnum status;
    @JsonProperty("online-players")
    private Integer onlinePlayers;

    public Server name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @ApiModelProperty(example = "lobby-1", value = "")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Server group(String group) {
        this.group = group;
        return this;
    }

    /**
     * Get group
     *
     * @return group
     */
    @ApiModelProperty(example = "lobby", value = "")


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Server ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * Get ipAddress
     *
     * @return ipAddress
     */
    @ApiModelProperty(example = "10.0.0.11", value = "")


    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Server status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Server Status
     *
     * @return status
     */
    @ApiModelProperty(example = "starting", value = "Server Status")


    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Server onlinePlayers(Integer onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
        return this;
    }

    /**
     * Get onlinePlayers
     *
     * @return onlinePlayers
     */
    @ApiModelProperty(example = "4", value = "")


    public Integer getOnlinePlayers() {
        return onlinePlayers;
    }

    public void setOnlinePlayers(Integer onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Server server = (Server) o;
        return Objects.equals(this.name, server.name) &&
                Objects.equals(this.group, server.group) &&
                Objects.equals(this.ipAddress, server.ipAddress) &&
                Objects.equals(this.status, server.status) &&
                Objects.equals(this.onlinePlayers, server.onlinePlayers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, ipAddress, status, onlinePlayers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Server {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    group: ").append(toIndentedString(group)).append("\n");
        sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    onlinePlayers: ").append(toIndentedString(onlinePlayers)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Server Status
     */
    public enum StatusEnum {
        STATING("stating"),

        ONLINE("online"),

        OFFLINE("offline");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + text + "'");
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }
}

