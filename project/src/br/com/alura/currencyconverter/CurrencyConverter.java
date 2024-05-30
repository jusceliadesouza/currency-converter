package project.src.br.com.alura.currencyconverter;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrencyConverter {
    private ApiClient apiClient = new ApiClient();
    private List<String> history = new ArrayList<>();

    public void convert(String fromCurrency, String toCurrency, double amount) {
        ConversionRates rates = apiClient.getConversionRates(fromCurrency);
        double rate = rates.getRate(toCurrency);
        double result = amount * rate;
        String conversion = String.format("%.2f %s = %.2f %s%n", amount, fromCurrency, result, toCurrency);

        // Log
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String logEntry = String.format("%s - %s", timestamp, conversion);
        history.add(logEntry);

        System.out.println(conversion);
    }

    public void printHistory() {
        System.out.println("Historico de Conversoes:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }
}
