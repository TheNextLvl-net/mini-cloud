package net.thenextlvl.cloud.object;

import java.io.File;

public interface ContainerizedObject {
    /**
     * Get the folder where this object is stored
     *
     * @return the object's container file
     */
    File getContainer();
}
