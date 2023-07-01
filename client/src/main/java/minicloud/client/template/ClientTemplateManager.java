package minicloud.client.template;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.object.Identifier;
import minicloud.api.template.Template;
import minicloud.api.template.TemplateManager;
import minicloud.client.http.Requests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class ClientTemplateManager implements TemplateManager {
    private final String serverUrl;

    @Override
    public List<Template> getTemplates() {
        try {
            var templates = Requests.<String>get(serverUrl + "/api/v1/template")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(templates, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Template> getTemplate(Identifier name) {
        try {
            var template = Requests.<String>get(serverUrl + "/api/v1/template/" + name)
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return Optional.ofNullable(new Gson().fromJson(template, new TypeToken<>() {
            }));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Template createTemplate(Identifier name, FileInputStream fileInput) throws IllegalStateException {
        try {
            var template = Requests.<String>post(serverUrl + "/api/v1/template?name=" + name,
                            HttpRequest.BodyPublishers.ofInputStream(() -> fileInput))
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(template, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeTemplate(Identifier template) {
        try {
            Requests.<Void>delete(serverUrl + "/api/v1/template/" + template)
                    .send(HttpResponse.BodyHandlers.discarding())
                    .body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Template updateFiles(Identifier name, FileInputStream fileInput) {
        try {
            var template = Requests.<String>put(serverUrl + "/api/v1/template?name=" + name,
                            HttpRequest.BodyPublishers.ofInputStream(() -> fileInput))
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return new Gson().fromJson(template, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InputStream downloadFiles(Identifier template, File destination) {
        try {
            return Requests.<InputStream>get(serverUrl + "/api/v1/template/" + template + "/download")
                    .send(HttpResponse.BodyHandlers.ofInputStream())
                    .body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
