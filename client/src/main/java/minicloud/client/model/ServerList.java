package minicloud.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.processing.Generated;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ServerList
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T02:45:50.392067379+02:00[Europe/Berlin]")
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

