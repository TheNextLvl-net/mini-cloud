package minicloud.api.template;

import org.intellij.lang.annotations.Pattern;
import org.intellij.lang.annotations.Subst;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
     * @param template the identifier of the desired template
     * @return the desired template
     */
    Optional<Template> getTemplate(@Pattern("^[a-zA-Z0-9_-]+$") String template);

    /**
     * Create a new template
     *
     * @param template  the name of the template
     * @param fileInput the file input to use as a template
     * @return the new template
     * @throws IllegalStateException thrown if a similar template already exists
     */
    @Subst("")
    Template createTemplate(@Pattern("^[a-zA-Z0-9_-]+$") String template, FileInputStream fileInput) throws IllegalStateException;

    /**
     * Remove an existing template
     *
     * @param template the template to remove
     */
    void removeTemplate(@Pattern("^[a-zA-Z0-9_-]+$") String template);

    /**
     * Update a template based on a file input stream
     *
     * @param template  the template to update the files for
     * @param fileInput the file input to use as a template
     * @return the updated template
     */
    Template updateFiles(@Pattern("^[a-zA-Z0-9_-]+$") String template, FileInputStream fileInput);

    /**
     * Download the files of a given template
     *
     * @param template    the template to download the files from
     * @param destination the destination to save the template files at
     * @return the input stream
     */
    InputStream downloadFiles(@Pattern("^[a-zA-Z0-9_-]+$") String template, File destination);
}
