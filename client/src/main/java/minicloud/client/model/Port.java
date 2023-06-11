package minicloud.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * Port
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T02:45:50.392067379+02:00[Europe/Berlin]")
public class Port {

  private String name;

  /**
   * Gets or Sets protocol
   */
  public enum ProtocolEnum {
    TCP("tcp"),
    
    UDP("udp"),
    
    SCTP("sctp");

    private String value;

    ProtocolEnum(String value) {
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
    public static ProtocolEnum fromValue(String value) {
      for (ProtocolEnum b : ProtocolEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ProtocolEnum protocol;

  private Integer targetPort;

  private Integer publishedPort;

  /**
   * Gets or Sets publishMode
   */
  public enum PublishModeEnum {
    INGRESS("ingress"),
    
    HOST("host");

    private String value;

    PublishModeEnum(String value) {
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
    public static PublishModeEnum fromValue(String value) {
      for (PublishModeEnum b : PublishModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private PublishModeEnum publishMode;

  public Port name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", example = "minecraft", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Port protocol(ProtocolEnum protocol) {
    this.protocol = protocol;
    return this;
  }

  /**
   * Get protocol
   * @return protocol
  */
  
  @Schema(name = "protocol", example = "tcp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("protocol")
  public ProtocolEnum getProtocol() {
    return protocol;
  }

  public void setProtocol(ProtocolEnum protocol) {
    this.protocol = protocol;
  }

  public Port targetPort(Integer targetPort) {
    this.targetPort = targetPort;
    return this;
  }

  /**
   * Get targetPort
   * @return targetPort
  */
  
  @Schema(name = "target-port", example = "25565", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("target-port")
  public Integer getTargetPort() {
    return targetPort;
  }

  public void setTargetPort(Integer targetPort) {
    this.targetPort = targetPort;
  }

  public Port publishedPort(Integer publishedPort) {
    this.publishedPort = publishedPort;
    return this;
  }

  /**
   * Get publishedPort
   * @return publishedPort
  */
  
  @Schema(name = "published-port", example = "25565", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("published-port")
  public Integer getPublishedPort() {
    return publishedPort;
  }

  public void setPublishedPort(Integer publishedPort) {
    this.publishedPort = publishedPort;
  }

  public Port publishMode(PublishModeEnum publishMode) {
    this.publishMode = publishMode;
    return this;
  }

  /**
   * Get publishMode
   * @return publishMode
  */
  
  @Schema(name = "publish-mode", example = "ingress", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("publish-mode")
  public PublishModeEnum getPublishMode() {
    return publishMode;
  }

  public void setPublishMode(PublishModeEnum publishMode) {
    this.publishMode = publishMode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Port port = (Port) o;
    return Objects.equals(this.name, port.name) &&
        Objects.equals(this.protocol, port.protocol) &&
        Objects.equals(this.targetPort, port.targetPort) &&
        Objects.equals(this.publishedPort, port.publishedPort) &&
        Objects.equals(this.publishMode, port.publishMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, protocol, targetPort, publishedPort, publishMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Port {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    targetPort: ").append(toIndentedString(targetPort)).append("\n");
    sb.append("    publishedPort: ").append(toIndentedString(publishedPort)).append("\n");
    sb.append("    publishMode: ").append(toIndentedString(publishMode)).append("\n");
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

