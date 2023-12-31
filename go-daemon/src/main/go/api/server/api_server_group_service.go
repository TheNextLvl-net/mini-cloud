/*
 * MiniCloud API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * API version: 1.0.0
 * Contact: apiteam@swagger.io
 * Generated by: OpenAPI Generator (https://openapi-generator.tech)
 */

package server

import (
	"context"
	"errors"
	"net/http"

	"github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go/daemon"
)

// ServerGroupApiService is a service that implements the logic for the ServerGroupApiServicer
// This service should implement the business logic for every endpoint for the ServerGroupApi API.
// Include any external packages or services that will be required by this service.
type ServerGroupApiService struct {
	daemon *daemon.Daemon
}

// NewServerGroupApiService creates a default api service
func NewServerGroupApiService(daemon *daemon.Daemon) ServerGroupApiServicer {
	return &ServerGroupApiService{daemon}
}

// CreateGroup - Create a new server group
func (s *ServerGroupApiService) CreateGroup(ctx context.Context, serverGroup daemon.ServerGroup) (ImplResponse, error) {
	// TODO - update CreateGroup with the required logic for this service method.
	// Add api_server_group_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(201, ServerGroup{}) or use other options such as http.Ok ...
	//return Response(201, ServerGroup{}), nil

	//TODO: Uncomment the next line to return response Response(400, {}) or use other options such as http.Ok ...
	//return Response(400, nil),nil

	//TODO: Uncomment the next line to return response Response(409, {}) or use other options such as http.Ok ...
	//return Response(409, nil),nil

	return Response(http.StatusNotImplemented, nil), errors.New("CreateGroup method not implemented")
}

// GetGroup - Get the server group
func (s *ServerGroupApiService) GetGroup(ctx context.Context, name string) (ImplResponse, error) {
	// TODO - update GetGroup with the required logic for this service method.
	// Add api_server_group_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	group, err := s.daemon.GetGroup(ctx, name)
	if err != nil {
		return Response(500, nil), err
	}

	if group == nil {
		return Response(404, nil), nil
	}

	return Response(200, *group), nil
}

// GetGroups - Get all server groups
func (s *ServerGroupApiService) GetGroups(ctx context.Context) (ImplResponse, error) {
	// TODO - update GetGroups with the required logic for this service method.
	// Add api_server_group_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	groups, err := s.daemon.ListGroups(ctx)

	if err != nil {
		return Response(500, nil), err
	}

	return Response(200, groups), nil
}

// GetServersInGroup - Get all servers of the group
func (s *ServerGroupApiService) GetServersInGroup(ctx context.Context, name string) (ImplResponse, error) {
	// TODO - update GetServersInGroup with the required logic for this service method.
	// Add api_server_group_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(200, []Server{}) or use other options such as http.Ok ...
	//return Response(200, []Server{}), nil

	//TODO: Uncomment the next line to return response Response(400, {}) or use other options such as http.Ok ...
	//return Response(400, nil),nil

	//TODO: Uncomment the next line to return response Response(404, {}) or use other options such as http.Ok ...
	//return Response(404, nil),nil

	return Response(http.StatusNotImplemented, nil), errors.New("GetServersInGroup method not implemented")
}

// RemoveGroup - Delete an existing server group
func (s *ServerGroupApiService) RemoveGroup(ctx context.Context, name string) (ImplResponse, error) {
	// TODO - update RemoveGroup with the required logic for this service method.
	// Add api_server_group_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(200, {}) or use other options such as http.Ok ...
	//return Response(200, nil),nil

	//TODO: Uncomment the next line to return response Response(400, {}) or use other options such as http.Ok ...
	//return Response(400, nil),nil

	//TODO: Uncomment the next line to return response Response(409, {}) or use other options such as http.Ok ...
	//return Response(409, nil),nil

	return Response(http.StatusNotImplemented, nil), errors.New("RemoveGroup method not implemented")
}
