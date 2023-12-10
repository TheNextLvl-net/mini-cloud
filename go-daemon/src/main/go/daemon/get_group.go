package daemon

import (
	"context"
	"fmt"

	mc "github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go"
	"github.com/docker/docker/api/types"
	"github.com/docker/docker/api/types/filters"
)

func (daemon *Daemon) GetGroup(ctx context.Context, name string) (*ServerGroup, error) {

	srvs, err := daemon.client.ServiceList(ctx, types.ServiceListOptions{
		Filters: filters.NewArgs(
			filters.Arg("label", mc.MiniCloudManagedLabel+"=true"),
			filters.Arg("label", mc.MiniCloudNameLabel+"="+name),
		),
	})

	if err != nil {
		return nil, err
	}

	if len(srvs) <= 0 {
		return nil, nil
	}

	group := ConstructGroup(srvs[0])
	if group == nil {
		return nil, fmt.Errorf("failed to convert the service to a group")
	}

	return group, nil
}
