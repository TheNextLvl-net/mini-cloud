package minicloud.api.template;

import minicloud.api.template.error.TemplateInUseException;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.util.Optional;
import java.util.stream.Stream;

public interface TemplateManager {
    /**
     * Get a list of all templates
     *
     * @return all templates
     */
    Stream<Template> getTemplates();

    /**
     * Get an existing template
     *
     * @param name the name of the desired template
     * @return the desired template
     */
    @Nullable Optional<Template> getTemplate(String name);

    /**
     * Create a new template
     *
     * @param name      the name of the template
     * @param fileInput the file input to use as a template
     * @return the new template
     * @throws IllegalStateException thrown if a similar template already exists
     */
    Template createTemplate(String name, FileInputStream fileInput) throws IllegalStateException;

    /**
     * Remove an existing template
     *
     * @param template the template to remove
     * @return whether the template was removed
     * @throws TemplateInUseException thrown if the template is used by a server
     */
    boolean removeTemplate(Template template) throws TemplateInUseException;
}
