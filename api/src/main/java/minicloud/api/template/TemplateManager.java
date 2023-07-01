package minicloud.api.template;

import minicloud.api.object.Identifier;

import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

public interface TemplateManager {
    /**
     * Get a list of all templates
     *
     * @return all templates
     */
    List<Template> getTemplates();

    /**
     * Get an existing template
     *
     * @param name the name of the desired template
     * @return the desired template
     */
    Optional<Template> getTemplate(Identifier name);

    /**
     * Create a new template
     *
     * @param name      the name of the template
     * @param fileInput the file input to use as a template
     * @return the new template
     * @throws IllegalStateException thrown if a similar template already exists
     */
    Template createTemplate(Identifier name, FileInputStream fileInput) throws IllegalStateException;

    /**
     * Remove an existing template
     *
     * @param template the template to remove
     */
    void removeTemplate(Identifier template);

    /**
     * Update a template based on a file input stream
     *
     * @param template  the template to update the files for
     * @param fileInput the file input to use as a template
     * @return the updated template
     */
    Template updateFiles(Identifier template, FileInputStream fileInput);

    /**
     * Download the files of a given template
     *
     * @param template    the template to download the files from
     * @param destination the destination to save the template files at
     * @return the input stream
     */
    InputStream downloadFiles(Identifier template, File destination);
}
