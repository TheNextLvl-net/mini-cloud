package daemon

import (
	"github.com/docker/docker/api/types/swarm"
)

func ContructPort(port swarm.PortConfig) Port {
	return Port{
		Name:          port.Name,
		Protocol:      string(port.Protocol),
		TargetPort:    int32(port.TargetPort),
		PublishedPort: int32(port.PublishedPort),
		PublishMode:   string(port.PublishMode),
	}
}

func ContructPorts(portConfigs []swarm.PortConfig) []Port {
	ports := make([]Port, len(portConfigs))
	for index, v := range portConfigs {
		ports[index] = ContructPort(v)
	}
	return ports
}
