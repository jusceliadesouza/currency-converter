package project.src.br.com.alura.currencyconverter;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {
    private ApiClient apiClient = new ApiClient();
    private List<String> history = new ArrayList<>();

    public void convert(String fromCurrency, String toCurrency, double amount) {
        ConversionRates rates = apiClient.getConversionRates(fromCurrency);
        double rate = rates.getRate(toCurrency);
        double result = amount * rate;
       String conversion = String.format("%.2f %s = %.2f %s%n", amount, fromCurrency, result, toCurrency);
        
        history.add(conversion);
        System.out.println(conversion);
    }

    public void printHistory() {
        System.out.println("Historico de Conversoes:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }
}
