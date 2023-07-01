package daemon

import (
	"github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go/api"
	"github.com/docker/docker/api/types/swarm"
)

func ContructPort(port swarm.PortConfig) api.Port {
	return api.Port{
		Name:          port.Name,
		Protocol:      string(port.Protocol),
		TargetPort:    int32(port.TargetPort),
		PublishedPort: int32(port.PublishedPort),
		PublishMode:   string(port.PublishMode),
	}
}

func ContructPorts(portConfigs []swarm.PortConfig) []api.Port {
	ports := make([]api.Port, len(portConfigs))
	for index, v := range portConfigs {
		ports[index] = ContructPort(v)
	}
	return ports
}
