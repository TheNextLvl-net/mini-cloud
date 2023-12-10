package minicloud.client.template;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.CloudProvider;
import minicloud.api.template.Template;
import minicloud.api.template.TemplateManager;
import minicloud.client.http.Requests;
import org.intellij.lang.annotations.Pattern;

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
    private final CloudProvider provider;
    private final Gson gson = new Gson();

    @Override
    public List<Template> getTemplates() {
        try {
            var templates = Requests.<String>get(provider.getServerUrl() + "/api/v1/template")
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return gson.fromJson(templates, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Template> getTemplate(@Pattern("^[a-zA-Z0-9_-]+$") String name) {
        try {
            var template = Requests.<String>get(provider.getServerUrl() + "/api/v1/template/" + name)
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return Optional.ofNullable(gson.fromJson(template, new TypeToken<>() {
            }));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Template createTemplate(@Pattern("^[a-zA-Z0-9_-]+$") String name, FileInputStream fileInput) throws IllegalStateException {
        try {
            var template = Requests.<String>post(provider.getServerUrl() + "/api/v1/template?name=" + name,
                            HttpRequest.BodyPublishers.ofInputStream(() -> fileInput))
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return gson.fromJson(template, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeTemplate(@Pattern("^[a-zA-Z0-9_-]+$") String template) {
        try {
            Requests.<Void>delete(provider.getServerUrl() + "/api/v1/template/" + template)
                    .send(HttpResponse.BodyHandlers.discarding())
                    .body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Template updateFiles(@Pattern("^[a-zA-Z0-9_-]+$") String name, FileInputStream fileInput) {
        try {
            var template = Requests.<String>put(provider.getServerUrl() + "/api/v1/template?name=" + name,
                            HttpRequest.BodyPublishers.ofInputStream(() -> fileInput))
                    .send(HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .body();
            return gson.fromJson(template, new TypeToken<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InputStream downloadFiles(@Pattern("^[a-zA-Z0-9_-]+$") String template, File destination) {
        try {
            return Requests.<InputStream>get(provider.getServerUrl() + "/api/v1/template/" + template + "/download")
                    .send(HttpResponse.BodyHandlers.ofInputStream())
                    .body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
