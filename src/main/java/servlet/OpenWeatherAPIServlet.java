package servlet;

import java.io.IOException;
import java.io.PrintWriter;

//import com.google.gson.JsonObject;

import consumoAPI.OpenWeatherAPI;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/OpenWeatherAPIServlet")
public class OpenWeatherAPIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityId = "3114710"; // ID de Asturias
        String weatherData = openWeatherAPI.getWeatherData(cityId);
        if (weatherData != null) {
         	
        	// Uso directo de los métodos para obtener la cidad, temperatura y descripción
                
            request.setAttribute("ciudad", openWeatherAPI.getCiudad(weatherData));
            request.setAttribute("temperature", openWeatherAPI.getTemperatura(weatherData));
            request.setAttribute("description", openWeatherAPI.getDescripcion(weatherData));
        	
        } else {
        	
        	// Para probar cuando la API no funcione
        	request.setAttribute("ciudad", "Asturias");
            request.setAttribute("temperature", "19");
            request.setAttribute("description", "Algo nublado");
        } 
        
        
    }

}
