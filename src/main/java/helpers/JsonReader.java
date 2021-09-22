package helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utilities.JsonManager;
import utilities.MyLogger;

public class JsonReader {
    private final String rootPath = "src/test/resources/";
    private final String fileName;
    private final JsonManager jsonManger;
    private Object currentObject = null;

    public JsonReader(String fileName) {
        this.fileName = fileName;
        jsonManger = new JsonManager(rootPath + fileName + ".json");
    }

    public JSONObject getJsonAsObject() {
        return jsonManger.getJsonObject();
    }

    public JSONArray getJsonAsArray() {
        return jsonManger.getJsonArray();
    }

    public JsonReader get(String key) {
        currentObject = currentObject == null ? getJsonAsObject().get(key)
                : ((JSONObject) currentObject).get(key);

        return this;
    }

    public JsonReader getFromArray(int index) {
        var arrayObject = currentObject == null ? getJsonAsArray()
                : (JSONArray) currentObject;

        if (index < arrayObject.size())
            currentObject = arrayObject.get(index);
        else MyLogger.warning(JsonReader.class.getSimpleName(), "The Index is out of border in "
                + fileName + "json file");

        return this;
    }

    public Object[] toArray() {
        var array = ((JSONArray) currentObject).toArray();
        currentObject = null;

        return array;
    }

    @Override
    public String toString() {
        var string = currentObject.toString();
        currentObject = null;

        return string;
    }
}
