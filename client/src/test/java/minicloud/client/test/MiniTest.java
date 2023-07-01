package minicloud.client.test;

import minicloud.api.CloudProvider;
import minicloud.api.group.ServerGroup;
import minicloud.api.networking.Port;
import minicloud.api.networking.Protocol;
import minicloud.api.networking.PublishMode;
import minicloud.api.object.Identifier;
import minicloud.client.ClientCloudProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class MiniTest {

    public static void main(String[] args) throws FileNotFoundException {
        CloudProvider cloud = new ClientCloudProvider("http://0.0.0.0:8080");
        var serverManager = cloud.getServerManager();
        var groupManager = cloud.getGroupManager();
        var templateManager = cloud.getTemplateManager();

        var lobbyTemplateFile = new File("/home/david/Desktop/Coding/paper/lobby-template.zip");
        var lobbyTemplate = templateManager.createTemplate(
                new Identifier("lobby-template"),
                new FileInputStream(lobbyTemplateFile)
        );

        var lobbyPort = new Port("lobby", Protocol.UDP, 25565, 25565, PublishMode.INGRESS);
        var lobbyGroup = groupManager.createGroup(new ServerGroup(
                new Identifier("lobby"),
                lobbyTemplate.getName(),
                List.of(lobbyPort),
                100
        ));
        int lobbyServers = groupManager.getServers(lobbyGroup.getName()).size();

        var lobbyServer = serverManager.createServer(
                new Identifier("lobby-" + lobbyServers + 1),
                lobbyGroup.getName()
        );

        var result = serverManager.start(lobbyServer.getName());
        result.whenComplete((response, throwable) -> {
            if (throwable != null) throwable.printStackTrace(); // could not start server
            else System.out.println("successfully started " + lobbyServer.getName());
        });
    }
}
