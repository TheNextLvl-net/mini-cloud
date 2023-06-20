package minicloud.client.template;

import minicloud.api.object.Identifier;
import minicloud.api.template.Template;
import minicloud.api.template.TemplateManager;

import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

public class ClientTemplateManager implements TemplateManager {
    @Override
    public List<Template> getTemplates() {
        return null;
    }

    @Override
    public Optional<Template> getTemplate(Identifier name) {
        return Optional.empty();
    }

    @Override
    public Template createTemplate(Identifier name, FileInputStream fileInput) throws IllegalStateException {
        return null;
    }

    @Override
    public void removeTemplate(Identifier template) {

    }
}
