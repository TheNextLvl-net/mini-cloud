package minicloud.client.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class Requests {

    public static <T> Request<T> get(String url) {
        var request = new Request<T>(url);
        request.getRequestBuilder().GET();
        return request;
    }

    public static <T> Request<T> put(String url, HttpRequest.BodyPublisher publisher) {
        var request = new Request<T>(url);
        request.getRequestBuilder().PUT(publisher);
        return request;
    }

    public static <T> Request<T> post(String url, HttpRequest.BodyPublisher publisher) {
        var request = new Request<T>(url);
        request.getRequestBuilder().POST(publisher);
        return request;
    }

    public static <T> Request<T> delete(String url) {
        var request = new Request<T>(url);
        request.getRequestBuilder().DELETE();
        return request;
    }

    @Getter
    @RequiredArgsConstructor
    public static class Request<T> {
        private final String url;
        private final HttpClient httpClient = HttpClient.newHttpClient();
        private final HttpRequest.Builder requestBuilder;

        private Request(String url) {
            this(url, HttpRequest.newBuilder(URI.create(url)));
            timeout(Duration.ofSeconds(3));
        }

        public Request<T> timeout(Duration duration) {
            getRequestBuilder().timeout(duration);
            return this;
        }

        public HttpResponse<T> send(HttpResponse.BodyHandler<T> handler) throws IOException, InterruptedException {
            return getHttpClient().send(getRequestBuilder().build(), handler);
        }

        public CompletableFuture<HttpResponse<T>> sendAsync(HttpResponse.BodyHandler<T> handler) {
            return getHttpClient().sendAsync(getRequestBuilder().build(), handler);
        }
    }
}
