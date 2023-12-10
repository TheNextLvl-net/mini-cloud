package daemon

import (
	"context"
	"io"

	mc "github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go"
	"github.com/docker/docker/api/types"
)

func (daemon *Daemon) CreateTemplate(ctx context.Context, name string, body io.ReadCloser) error {
	daemon.client.ImageBuild(ctx, body, types.ImageBuildOptions{Tags: []string{name + ":latest"}, Labels: map[string]string{
		mc.MiniCloudManagedLabel: "true",
	}})
	_, err := daemon.client.ImagePush(ctx, "localhost/"+name+":latest", types.ImagePushOptions{})
	if err != nil {
		return err
	}
	return nil
}
