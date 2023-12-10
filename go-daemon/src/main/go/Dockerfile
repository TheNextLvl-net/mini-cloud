FROM golang:1.19 AS build

COPY . /tmp/build/
WORKDIR /tmp/build/
RUN CGO_ENABLED=0 go build ./cmd/minicloudd

FROM alpine:latest
COPY --from=build /tmp/build/minicloudd /opt/minicloud/

WORKDIR /opt/minicloud/
CMD [ "/opt/minicloud/minicloudd" ]

