package minicloud.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import minicloud.client.model.Server;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ServerList
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ServerList {

  @Valid
  private List<@Valid Server> servers;

  public ServerList servers(List<@Valid Server> servers) {
    this.servers = servers;
    return this;
  }

  public ServerList addServersItem(Server serversItem) {
    if (this.servers == null) {
      this.servers = new ArrayList<>();
    }
    this.servers.add(serversItem);
    return this;
  }

  /**
   * Get servers
   * @return servers
  */
  @Valid 
  @Schema(name = "servers", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("servers")
  public List<@Valid Server> getServers() {
    return servers;
  }

  public void setServers(List<@Valid Server> servers) {
    this.servers = servers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerList serverList = (ServerList) o;
    return Objects.equals(this.servers, serverList.servers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(servers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerList {\n");
    sb.append("    servers: ").append(toIndentedString(servers)).append("\n");
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

