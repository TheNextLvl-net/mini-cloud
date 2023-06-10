package net.thenextlvl.cloud.template;

import java.util.Collection;

public interface TemplateManager {
    Collection<? extends Template> getTemplates();

    Template createTemplate();

    boolean removeTemplate(Template template);
}
