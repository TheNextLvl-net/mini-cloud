package net.thenextlvl.cloud.velocity.server;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.thenextlvl.cloud.server.ServerConfiguration;

import java.net.InetSocketAddress;

@Getter
@RequiredArgsConstructor
public class VelocityServerConfiguration implements ServerConfiguration {
    private final InetSocketAddress address;
    private final String[] startCommand;
}
