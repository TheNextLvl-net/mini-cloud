package group

import (
	"context"
	"easy-cloud-server/cmd/minicloudd/app"
	sw "easy-cloud-server/swagger/go/model"
	"encoding/json"
	"net/http"
	"strconv"

	mc "easy-cloud-server"

	"github.com/docker/docker/api/types"
	"github.com/docker/docker/api/types/filters"
)

func GetGroupsRequest(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json; charset=UTF-8")

	groups, err := GetGroups()
	if err != nil {
		w.WriteHeader(http.StatusInternalServerError)
		return
	}
	result, err := json.Marshal(groups)
	if err != nil {
		w.WriteHeader(http.StatusInternalServerError)
		return
	}

	w.WriteHeader(http.StatusOK)
	w.Write(result)
}

func GetGroups() ([]*sw.ServerGroup, error) {

	ctx := context.Background()
	srvs, err := app.DockerClient.ServiceList(ctx, types.ServiceListOptions{
		Filters: filters.NewArgs(filters.Arg("label", mc.MiniCloudManagedLabel+"=true")),
	})
	if err != nil {
		return nil, err
	}

	groups := make([]*sw.ServerGroup, len(srvs))

	for index, service := range srvs {

		servicePorts := service.Endpoint.Ports
		ports := make([]sw.Port, len(servicePorts))
		for index, v := range servicePorts {
			ports[index] = sw.Port{
				Name:          v.Name,
				Protocol:      string(v.Protocol),
				TargetPort:    int32(v.TargetPort),
				PublishedPort: int32(v.PublishedPort),
				PublishMode:   string(v.PublishMode),
			}
		}

		maxPlayersPerServer := service.Spec.Labels[mc.MiniCloudMaxPlayersPerServerLabel]
		count, err := strconv.Atoi(maxPlayersPerServer)
		if err != nil {
			return nil, err
		}

		groups[index] = &sw.ServerGroup{
			Name:                service.Spec.Name,
			Ports:               ports,
			Template:            service.Spec.Labels[mc.MiniCloudTemplateLabel],
			MaxPlayersPerServer: int32(count),
		}
	}

	return groups, nil
}
