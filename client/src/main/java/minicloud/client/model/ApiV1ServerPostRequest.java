package minicloud.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.annotation.processing.Generated;
import java.util.Arrays;
import java.util.Objects;

/**
 * ApiV1ServerPostRequest
 */

@JsonTypeName("_api_v1_server_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T02:45:50.392067379+02:00[Europe/Berlin]")
public class ApiV1ServerPostRequest {

  private JsonNullable<String> group = JsonNullable.undefined();

  public ApiV1ServerPostRequest group(String group) {
    this.group = JsonNullable.of(group);
    return this;
  }

  /**
   * Get group
   * @return group
  */
  
  @Schema(name = "group", example = "lobby", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("group")
  public JsonNullable<String> getGroup() {
    return group;
  }

  public void setGroup(JsonNullable<String> group) {
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiV1ServerPostRequest apiV1ServerPostRequest = (ApiV1ServerPostRequest) o;
    return equalsNullable(this.group, apiV1ServerPostRequest.group);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(group));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiV1ServerPostRequest {\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
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

