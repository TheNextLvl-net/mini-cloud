package net.thenextlvl.cloud.template;

import net.thenextlvl.cloud.object.ContainerizedObject;
import net.thenextlvl.cloud.template.error.TemplateInUseException;

import java.util.Collection;

public interface TemplateManager extends ContainerizedObject {
    /**
     * Get a list of all templates
     *
     * @return all templates
     */
    Collection<? extends Template> getTemplates();

    /**
     * Create a new template
     *
     * @return the new template
     */
    Template createTemplate(String name);

    /**
     * Remove an existing template
     *
     * @param template the template to remove
     * @return whether the template was removed
     * @throws TemplateInUseException thrown if the template is used by a server
     */
    boolean removeTemplate(Template template) throws TemplateInUseException;
}
