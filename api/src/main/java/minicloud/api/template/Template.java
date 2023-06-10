package minicloud.api.template;

import minicloud.api.object.IdentifiableObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.concurrent.CompletableFuture;

public interface Template extends IdentifiableObject {
    /**
     * Get the start command of the template
     *
     * @return the command
     */
    String[] getCommand();

    /**
     * Get the size of the template in bytes
     *
     * @return the template size
     */
    int getSize();

    /**
     * Get the date when the template was created
     *
     * @return the date of creation
     */
    DateFormat getCreatedAt();

    /**
     * Get the date when the template was last updated
     *
     * @return the date of last modification
     */
    DateFormat getUpdatedAt();

    /**
     * Update the template based on a file input stream
     *
     * @param fileInput the file input to use as a template
     * @return a completable future providing the updated template
     */
    CompletableFuture<Template> updateFiles(FileInputStream fileInput);

    /**
     * Download the template files
     *
     * @param destination the destination to save the template files at
     * @return a file output stream
     */
    FileOutputStream downloadFiles(File destination);
}
