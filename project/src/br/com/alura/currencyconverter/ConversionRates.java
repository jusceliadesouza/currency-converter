package project.src.br.com.alura.currencyconverter;

import java.util.Map;
public class ConversionRates {
  private String result;
  private Map<String, Double> conversion_rates;

  public String getResult() {
      return result;
  }

  public double getRate(String currency) {
      return conversion_rates.get(currency);
  }
}