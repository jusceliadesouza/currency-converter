package project.src.br.com.alura.currencyconverter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ApiClient {
  private static final String API_URL = "https://v6.exchangerate-api.com/v6/3cde8ac84a77bf1d7baf86fc/latest/USD";

    public ConversionRates getConversionRates(String baseCurrency) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL.replace("USD", baseCurrency)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ConversionRates.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
