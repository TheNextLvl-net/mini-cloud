package daemon

import (
	"context"

	mc "github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go"
	"github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go/api"
	"github.com/docker/docker/api/types"
	"github.com/docker/docker/api/types/filters"
)

func (daemon *Daemon) ListGroups(ctx context.Context) ([]api.ServerGroup, error) {
	srvs, err := daemon.client.ServiceList(ctx, types.ServiceListOptions{
		Filters: filters.NewArgs(filters.Arg("label", mc.MiniCloudManagedLabel+"=true")),
	})
	if err != nil {
		return nil, err
	}

	groups := make([]api.ServerGroup, 0, len(srvs))

	for _, service := range srvs {
		group := ConstructGroup(service)
		if group == nil {
			continue
		}
		groups = append(groups, *group)
	}
	return groups, nil
}
