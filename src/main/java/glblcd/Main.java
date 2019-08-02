package glblcd;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.lang.model.type.ReferenceType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        var fileContent = Files.readAllBytes(Paths.get("src/main/resources/cake.json"));
        var json = new String(fileContent);


        System.out.println(fileContent);

        var map = new ObjectMapper();

        var type = new TypeReference<HashMap<String, Object>>(){};

        Map<String, Object> productJson = map.readValue(json, type);
                System.out.println(productJson);

    }
}
