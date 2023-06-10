package net.thenextlvl.cloud.group;

import net.thenextlvl.cloud.object.IdentifiableObject;
import net.thenextlvl.cloud.server.Server;

import java.util.Collection;

public interface Group extends IdentifiableObject {
    Collection<? extends Server> getServers();
}
