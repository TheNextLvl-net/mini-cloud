package net.thenextlvl.cloud.server;

import java.net.InetSocketAddress;

public interface ServerConfiguration {
    InetSocketAddress getAddress();

    String[] getStartCommand();
}
