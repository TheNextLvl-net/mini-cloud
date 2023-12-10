package daemon

import "github.com/docker/docker/client"

type Daemon struct {
	client *client.Client
}

func NewDaemon(client *client.Client) *Daemon {
	return &Daemon{client: client}
}
