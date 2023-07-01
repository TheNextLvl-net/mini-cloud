package app

import (
	"context"
	"fmt"
	"log"
	"net/http"

	"github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go/api/server"
	"github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go/daemon"

	"github.com/docker/docker/client"
)

var DockerClient *client.Client

func Run() {

	DockerClient, err := client.NewClientWithOpts(client.FromEnv, client.WithAPIVersionNegotiation())
	defer DockerClient.Close()
	if err != nil {
		panic(err)
	}
	ping, err := DockerClient.Ping(context.Background())
	if err != nil {
		panic(fmt.Errorf("cannot access docker"))
	}
	fmt.Printf("The minicloud runs on %s docker using api version %s\n", ping.OSType, ping.APIVersion)

	_, err = DockerClient.SwarmInspect(context.Background())
	if err != nil {
		panic(fmt.Errorf("the minicloud needs a docker swarm to start"))
	}

	daemon := daemon.NewDaemon(DockerClient)

	ServerApiService := server.NewServerApiService()
	ServerApiController := server.NewServerApiController(ServerApiService)

	ServerGroupApiService := server.NewServerGroupApiService(daemon)
	ServerGroupApiController := server.NewServerGroupApiController(ServerGroupApiService)

	SystemApiService := server.NewSystemApiService()
	SystemApiController := server.NewSystemApiController(SystemApiService)

	TemplateApiService := server.NewTemplateApiService()
	TemplateApiController := server.NewTemplateApiController(TemplateApiService)

	router := server.NewRouter(ServerApiController, ServerGroupApiController, SystemApiController, TemplateApiController)

	log.Printf("Starting server...")
	log.Fatal(http.ListenAndServe(":8080", server.Logger(router, "Handles")))
}
