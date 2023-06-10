package minicloud.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Port
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T01:47:26.496206287+02:00[Europe/Berlin]")

public class Port   {
  @JsonProperty("name")
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

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProtocolEnum fromValue(String text) {
      for (ProtocolEnum b : ProtocolEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("protocol")
  private ProtocolEnum protocol;

  @JsonProperty("target-port")
  private Integer targetPort;

  @JsonProperty("published-port")
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

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PublishModeEnum fromValue(String text) {
      for (PublishModeEnum b : PublishModeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("publish-mode")
  private PublishModeEnum publishMode;

  public Port name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "minecraft", value = "")


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
  @ApiModelProperty(example = "tcp", value = "")


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
  @ApiModelProperty(example = "25565", value = "")


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
  @ApiModelProperty(example = "25565", value = "")


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
  @ApiModelProperty(example = "ingress", value = "")


  public PublishModeEnum getPublishMode() {
    return publishMode;
  }

  public void setPublishMode(PublishModeEnum publishMode) {
    this.publishMode = publishMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

