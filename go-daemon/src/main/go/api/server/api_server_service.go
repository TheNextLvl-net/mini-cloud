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

// ServerApiService is a service that implements the logic for the ServerApiServicer
// This service should implement the business logic for every endpoint for the ServerApi API.
// Include any external packages or services that will be required by this service.
type ServerApiService struct {
}

// NewServerApiService creates a default api service
func NewServerApiService() ServerApiServicer {
	return &ServerApiService{}
}

// CreateServer - Create a new server
func (s *ServerApiService) CreateServer(ctx context.Context, createServerRequest daemon.CreateServerRequest) (ImplResponse, error) {
	// TODO - update CreateServer with the required logic for this service method.
	// Add api_server_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(201, Server{}) or use other options such as http.Ok ...
	//return Response(201, Server{}), nil

	//TODO: Uncomment the next line to return response Response(400, {}) or use other options such as http.Ok ...
	//return Response(400, nil),nil

	//TODO: Uncomment the next line to return response Response(409, {}) or use other options such as http.Ok ...
	//return Response(409, nil),nil

	return Response(http.StatusNotImplemented, nil), errors.New("CreateServer method not implemented")
}

// GetServer - Get the server
func (s *ServerApiService) GetServer(ctx context.Context, name string) (ImplResponse, error) {
	// TODO - update GetServer with the required logic for this service method.
	// Add api_server_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(200, Server{}) or use other options such as http.Ok ...
	//return Response(200, Server{}), nil

	//TODO: Uncomment the next line to return response Response(400, {}) or use other options such as http.Ok ...
	//return Response(400, nil),nil

	//TODO: Uncomment the next line to return response Response(404, {}) or use other options such as http.Ok ...
	//return Response(404, nil),nil

	return Response(http.StatusNotImplemented, nil), errors.New("GetServer method not implemented")
}

// GetServers - Get all servers
func (s *ServerApiService) GetServers(ctx context.Context) (ImplResponse, error) {
	// TODO - update GetServers with the required logic for this service method.
	// Add api_server_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(200, []Server{}) or use other options such as http.Ok ...
	//return Response(200, []Server{}), nil

	return Response(http.StatusNotImplemented, nil), errors.New("GetServers method not implemented")
}

// RemoveServer - Delete an existing server
func (s *ServerApiService) RemoveServer(ctx context.Context, name string) (ImplResponse, error) {
	// TODO - update RemoveServer with the required logic for this service method.
	// Add api_server_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(200, {}) or use other options such as http.Ok ...
	//return Response(200, nil),nil

	//TODO: Uncomment the next line to return response Response(400, {}) or use other options such as http.Ok ...
	//return Response(400, nil),nil

	//TODO: Uncomment the next line to return response Response(404, {}) or use other options such as http.Ok ...
	//return Response(404, nil),nil

	return Response(http.StatusNotImplemented, nil), errors.New("RemoveServer method not implemented")
}

// StartServer - Start the server
func (s *ServerApiService) StartServer(ctx context.Context, name string) (ImplResponse, error) {
	// TODO - update StartServer with the required logic for this service method.
	// Add api_server_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(200, {}) or use other options such as http.Ok ...
	//return Response(200, nil),nil

	//TODO: Uncomment the next line to return response Response(400, {}) or use other options such as http.Ok ...
	//return Response(400, nil),nil

	//TODO: Uncomment the next line to return response Response(404, {}) or use other options such as http.Ok ...
	//return Response(404, nil),nil

	return Response(http.StatusNotImplemented, nil), errors.New("StartServer method not implemented")
}

// StopServer - Stop the server
func (s *ServerApiService) StopServer(ctx context.Context, name string) (ImplResponse, error) {
	// TODO - update StopServer with the required logic for this service method.
	// Add api_server_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(200, {}) or use other options such as http.Ok ...
	//return Response(200, nil),nil

	//TODO: Uncomment the next line to return response Response(400, {}) or use other options such as http.Ok ...
	//return Response(400, nil),nil

	//TODO: Uncomment the next line to return response Response(404, {}) or use other options such as http.Ok ...
	//return Response(404, nil),nil

	return Response(http.StatusNotImplemented, nil), errors.New("StopServer method not implemented")
}
