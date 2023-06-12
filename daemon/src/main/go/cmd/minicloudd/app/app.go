package app

import (
	"log"
	"net/http"

	sw "github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go"

	"github.com/docker/docker/client"
)

var DockerClient *client.Client

func Run() {

	DockerClient, err := client.NewClientWithOpts(client.FromEnv, client.WithAPIVersionNegotiation())
	defer DockerClient.Close()
	if err != nil {
		panic(err)
	}

	router := sw.NewRouter()
	log.Fatal(http.ListenAndServe(":8081", router))
}
