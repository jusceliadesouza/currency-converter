package project.src.br.com.alura.currencyconverter;

public class CurrencyConverter {
    private ApiClient apiClient = new ApiClient();

    public void convert(String fromCurrency, String toCurrency, double amount) {
        ConversionRates rates = apiClient.getConversionRates(fromCurrency);
        double rate = rates.getRate(toCurrency);
        double result = amount * rate;
        System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, result, toCurrency);
    }
}
