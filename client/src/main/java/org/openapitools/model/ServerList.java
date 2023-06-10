package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.Server;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ServerList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T01:25:54.107288741+02:00[Europe/Berlin]")

public class ServerList   {
  @JsonProperty("servers")
  @Valid
  private List<Server> servers = null;

  public ServerList servers(List<Server> servers) {
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
  @ApiModelProperty(value = "")

  @Valid

  public List<Server> getServers() {
    return servers;
  }

  public void setServers(List<Server> servers) {
    this.servers = servers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

