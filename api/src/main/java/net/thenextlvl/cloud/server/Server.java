package net.thenextlvl.cloud.server;

import net.thenextlvl.cloud.group.Group;
import net.thenextlvl.cloud.object.IdentifiableObject;

import java.io.File;

public interface Server extends IdentifiableObject {
    File getTemplate();

    Group getGroup();

    Status getStatus();

    int getOnlinePlayers();

    int getMaxPlayers();

    boolean start();
}
