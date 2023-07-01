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

	"github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go/api"
)

// SystemApiService is a service that implements the logic for the SystemApiServicer
// This service should implement the business logic for every endpoint for the SystemApi API.
// Include any external packages or services that will be required by this service.
type SystemApiService struct {
}

// NewSystemApiService creates a default api service
func NewSystemApiService() SystemApiServicer {
	return &SystemApiService{}
}

// ListenEvents - Monitor events
func (s *SystemApiService) ListenEvents(ctx context.Context, eventsRequest api.EventsRequest) (ImplResponse, error) {
	// TODO - update ListenEvents with the required logic for this service method.
	// Add api_system_service.go to the .openapi-generator-ignore to avoid overwriting this service implementation when updating open api generation.

	//TODO: Uncomment the next line to return response Response(200, EventMessage{}) or use other options such as http.Ok ...
	//return Response(200, EventMessage{}), nil

	return Response(http.StatusNotImplemented, nil), errors.New("ListenEvents method not implemented")
}