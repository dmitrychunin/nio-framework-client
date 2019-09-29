package ru.otus.javadeveloper.nio.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.format;

public class HttpIoClient {
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    public static void main(String[] args) {
        new Thread(() -> new HttpIoClient().post(format("http://%s:%s/some/url?param1=valu1&param2=value2", HOST, PORT), "testData_0")).start();
        new Thread(() -> new HttpIoClient().post(format("http://%s:%s/some/url?param1=valu1&param2=value2",HOST, PORT), "testData_1")).start();
    }

    public void post(String uri, String data) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Accept", "plain/text")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();

        HttpResponse<?> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
    }
}
