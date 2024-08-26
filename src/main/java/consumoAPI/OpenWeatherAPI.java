package consumoAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenWeatherAPI {
	
    private static final String API_KEY = "9d182a235ed381d66e011200fea0a05e";
	private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public String getWeatherData(String cityId) {
        String url = BASE_URL + "?id=" + cityId + "&appid=" + API_KEY + "&units=metric&lang=sp";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.out.println("Error: " + response.statusCode() + " " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para obtener el JSON
    public JsonObject parseWeatherData(String weatherData) {
        Gson gson = new Gson();
        return gson.fromJson(weatherData, JsonObject.class);
    }
    
   // Método para obtener la nombre de la Ciudad desde el JSON
    public String getCiudad(String weatherData) {
    	
    	// Parseamos el JSON desde la cadena de texto usando JsonParser
        JsonObject json = JsonParser.parseString(weatherData).getAsJsonObject();
        
        // Obtenemos el valor de "name" directamente como una cadena
        return json.get("name").getAsString();
    }
    
    // Método para obtener la temperatura desde el JSON
    public String getTemperatura(String weatherData) {
        JsonObject json = JsonParser.parseString(weatherData).getAsJsonObject();
        return json.getAsJsonObject("main").get("temp").getAsString();
    }

    // Método para obtener la descripción del clima desde el JSON
    public String getDescripcion(String weatherData) {
        JsonObject json = JsonParser.parseString(weatherData).getAsJsonObject();
        return json.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
    }

}
