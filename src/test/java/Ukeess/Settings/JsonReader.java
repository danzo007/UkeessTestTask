package Ukeess.Settings;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
    private String jsonDataAsString;

    public String readFromJson(String getTextFromJson){
        {
            try {
                jsonDataAsString = new String(Files.readAllBytes(Paths.get(".json")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        JSONObject jsonData = new JSONObject(jsonDataAsString);
        return (String) jsonData.get(getTextFromJson);
    }




}
