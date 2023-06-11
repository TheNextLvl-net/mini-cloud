package minicloud.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.processing.Generated;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ServerGroup
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T02:45:50.392067379+02:00[Europe/Berlin]")
public class ServerGroup {

  private String name;

  private String template;

  @Valid
  private List<@Valid Port> ports;

  private Integer maxPlayersPerServer;

  public ServerGroup name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @Pattern(regexp = "^[a-zA-Z0-9-_]+$") 
  @Schema(name = "name", example = "lobby", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
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
  @Pattern(regexp = "^[a-zA-Z0-9-_]+$") 
  @Schema(name = "template", example = "lobby-template", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("template")
  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public ServerGroup ports(List<@Valid Port> ports) {
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
  @Valid 
  @Schema(name = "ports", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ports")
  public List<@Valid Port> getPorts() {
    return ports;
  }

  public void setPorts(List<@Valid Port> ports) {
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
  
  @Schema(name = "max-players-per-server", example = "20", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max-players-per-server")
  public Integer getMaxPlayersPerServer() {
    return maxPlayersPerServer;
  }

  public void setMaxPlayersPerServer(Integer maxPlayersPerServer) {
    this.maxPlayersPerServer = maxPlayersPerServer;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

