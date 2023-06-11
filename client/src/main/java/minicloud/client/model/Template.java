package minicloud.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Template
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T02:15:12.085392277+02:00[Europe/Berlin]")

public class Template {
    @JsonProperty("name")
    private String name;

    @JsonProperty("command")
    private String command;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    public Template name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @ApiModelProperty(example = "lobby-template", value = "")

    @Pattern(regexp = "^[a-zA-Z0-9-_]+$")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Template command(String command) {
        this.command = command;
        return this;
    }

    /**
     * Get command
     *
     * @return command
     */
    @ApiModelProperty(example = "java -jar server.jar", value = "")


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Template size(Integer size) {
        this.size = size;
        return this;
    }

    /**
     * Get size
     *
     * @return size
     */
    @ApiModelProperty(value = "")


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Template createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @ApiModelProperty(value = "")

    @Valid

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Template updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     */
    @ApiModelProperty(value = "")

    @Valid

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Template template = (Template) o;
        return Objects.equals(this.name, template.name) &&
                Objects.equals(this.command, template.command) &&
                Objects.equals(this.size, template.size) &&
                Objects.equals(this.createdAt, template.createdAt) &&
                Objects.equals(this.updatedAt, template.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, command, size, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Template {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    command: ").append(toIndentedString(command)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

