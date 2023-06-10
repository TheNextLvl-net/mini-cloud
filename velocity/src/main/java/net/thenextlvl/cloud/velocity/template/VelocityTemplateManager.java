package net.thenextlvl.cloud.velocity.template;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.thenextlvl.cloud.template.Template;
import net.thenextlvl.cloud.template.TemplateManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class VelocityTemplateManager implements TemplateManager {
    private final List<Template> templates = new ArrayList<>();
    private final File container;

    @Override
    public Template createTemplate(String name) {
        return new VelocityTemplate(name, new File(getContainer(), name));
    }

    @Override
    public boolean removeTemplate(Template template) {
        return templates.remove(template);
    }
}
