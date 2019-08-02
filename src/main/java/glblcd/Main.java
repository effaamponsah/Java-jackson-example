package glblcd;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.lang.model.type.ReferenceType;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        String location = "https://facebook.github.io/react-native/movies.json";
        var client = HttpClient.newBuilder().build();
        URI url;

        url = new URI(location);

        var request = HttpRequest.newBuilder(url).build();
        var res = client.send(request, HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));

//        System.out.println(res.body());
        System.out.println(parseJson(res.body()));

        Main m = new Main();
        System.out.println(m.run());

    }


    public static Map<String, Object> parseJson(String json) throws IOException {
        var map = new ObjectMapper();
        var type = new TypeReference<HashMap<String, Object>>(){};
        Map<String, Object> productJson = map.readValue(json, type);
        return productJson;
    }

    private Map<String, Object> run() throws IOException {
        String json = null;
            var contents = Files.readAllBytes(Paths.get("src/main/resources/cake.json"));
            json = new String(contents);
            return parseJson(json);
    }
}
