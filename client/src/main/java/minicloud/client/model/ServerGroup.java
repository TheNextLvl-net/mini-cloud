package minicloud.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import minicloud.client.model.Port;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ServerGroup
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T01:47:26.496206287+02:00[Europe/Berlin]")

public class ServerGroup   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("template")
  private String template;

  @JsonProperty("ports")
  @Valid
  private List<Port> ports = null;

  @JsonProperty("max-players-per-server")
  private Integer maxPlayersPerServer;

  public ServerGroup name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "lobby", value = "")

@Pattern(regexp="^[a-zA-Z0-9-_]+$") 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServerGroup template(String template) {
    this.template = template;
    return this;
  }

  /**
   * Get template
   * @return template
  */
  @ApiModelProperty(example = "lobby-template", value = "")

@Pattern(regexp="^[a-zA-Z0-9-_]+$") 
  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public ServerGroup ports(List<Port> ports) {
    this.ports = ports;
    return this;
  }

  public ServerGroup addPortsItem(Port portsItem) {
    if (this.ports == null) {
      this.ports = new ArrayList<>();
    }
    this.ports.add(portsItem);
    return this;
  }

  /**
   * Get ports
   * @return ports
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Port> getPorts() {
    return ports;
  }

  public void setPorts(List<Port> ports) {
    this.ports = ports;
  }

  public ServerGroup maxPlayersPerServer(Integer maxPlayersPerServer) {
    this.maxPlayersPerServer = maxPlayersPerServer;
    return this;
  }

  /**
   * Get maxPlayersPerServer
   * @return maxPlayersPerServer
  */
  @ApiModelProperty(example = "20", value = "")


  public Integer getMaxPlayersPerServer() {
    return maxPlayersPerServer;
  }

  public void setMaxPlayersPerServer(Integer maxPlayersPerServer) {
    this.maxPlayersPerServer = maxPlayersPerServer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerGroup serverGroup = (ServerGroup) o;
    return Objects.equals(this.name, serverGroup.name) &&
        Objects.equals(this.template, serverGroup.template) &&
        Objects.equals(this.ports, serverGroup.ports) &&
        Objects.equals(this.maxPlayersPerServer, serverGroup.maxPlayersPerServer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, template, ports, maxPlayersPerServer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerGroup {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    ports: ").append(toIndentedString(ports)).append("\n");
    sb.append("    maxPlayersPerServer: ").append(toIndentedString(maxPlayersPerServer)).append("\n");
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

