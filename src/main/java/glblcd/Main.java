package glblcd;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        var file = Files.readAllBytes(Paths.get("src/main/resources/cake.json"));

//        var map = new ObjectMapper();
        System.out.println(file);
    }
}
