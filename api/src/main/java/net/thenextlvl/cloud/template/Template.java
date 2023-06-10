package net.thenextlvl.cloud.template;

import net.thenextlvl.cloud.object.IdentifiableObject;

import java.io.FileInputStream;
import java.text.DateFormat;

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
     */
    void updateFiles(FileInputStream fileInput);
}
