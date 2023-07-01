package daemon

import (
	"strconv"

	mc "github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go"
	"github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go/api"
	"github.com/docker/docker/api/types/swarm"
)

func ConstructGroup(srv swarm.Service) *api.ServerGroup {

	maxPlayersPerServer, ok := srv.Spec.Labels[mc.MiniCloudMaxPlayersPerServerLabel]
	if !ok {
		maxPlayersPerServer = "0"
	}

	count, err := strconv.Atoi(maxPlayersPerServer)
	if err != nil {
		return nil
	}

	return &api.ServerGroup{
		Name:                srv.Spec.Name,
		Ports:               ContructPorts(srv.Endpoint.Ports),
		Template:            srv.Spec.Labels[mc.MiniCloudTemplateLabel],
		MaxPlayersPerServer: int32(count),
	}
}
