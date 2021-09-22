package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonManager {
    private final String filePath;

    public JsonManager(String filePath) {
        this.filePath = filePath;
    }

    private Object loadJsonFile() {
        var jsonParser = new JSONParser();
        Object json = null;

        try (FileReader reader = new FileReader(filePath))
        {
            //Read JSON file
            json = jsonParser.parse(reader);
        } catch (ParseException | IOException e) {
            MyLogger.severe(JsonManager.class.getSimpleName(), "Can't read data from: "+ filePath);
            e.printStackTrace();
        }
        return json;
    }

    public JSONObject getJsonObject(){
        return (JSONObject) loadJsonFile();
    }

    public JSONArray getJsonArray() {
        return (JSONArray) loadJsonFile();
    }


}
