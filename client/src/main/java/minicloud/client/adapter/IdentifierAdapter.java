package minicloud.client.adapter;

import com.google.gson.*;
import minicloud.api.object.Identifier;

import java.lang.reflect.Type;

public class IdentifierAdapter implements JsonDeserializer<Identifier>, JsonSerializer<Identifier> {
    @Override
    public Identifier deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        return new Identifier(element.getAsString());
    }

    @Override
    public JsonElement serialize(Identifier identifier, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(identifier.toString());
    }
}
