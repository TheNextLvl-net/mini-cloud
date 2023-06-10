package net.thenextlvl.cloud.server;

import net.thenextlvl.cloud.template.Template;

import java.util.Collection;

public interface ServerManager {
    Collection<? extends Server> getServers();

    Server createServer(Template template);

    boolean removeServer(Server server);
}
