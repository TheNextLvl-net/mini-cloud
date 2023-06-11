package minicloud.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * Server
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T02:45:50.392067379+02:00[Europe/Berlin]")
public class Server {

  private String name;

  private String group;

  private String ipAddress;

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

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  private Integer onlinePlayers;

  public Server name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", example = "lobby-1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
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
   * @return group
  */
  
  @Schema(name = "group", example = "lobby", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("group")
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
   * @return ipAddress
  */
  
  @Schema(name = "ip-address", example = "10.0.0.11", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ip-address")
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
   * @return status
  */
  
  @Schema(name = "status", example = "starting", description = "Server Status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
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
   * @return onlinePlayers
  */
  
  @Schema(name = "online-players", example = "4", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("online-players")
  public Integer getOnlinePlayers() {
    return onlinePlayers;
  }

  public void setOnlinePlayers(Integer onlinePlayers) {
    this.onlinePlayers = onlinePlayers;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

