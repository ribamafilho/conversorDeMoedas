import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/22921d9f345655747fb36172/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Bem-vindo ao Conversor de Moedas!");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1. USD para BRL");
            System.out.println("2. BRL para USD");
            System.out.println("3. EUR para BRL");
            System.out.println("4. BRL para EUR");
            System.out.println("5. USD para EUR");
            System.out.println("6. EUR para USD");
            System.out.print("Digite o número da sua escolha: ");
            int choice = scanner.nextInt();

            System.out.print("Digite o valor a ser convertido: ");
            double amount = scanner.nextDouble();

            String fromCurrency = "";
            String toCurrency = "";

            switch (choice) {
                case 1 -> {
                    fromCurrency = "USD";
                    toCurrency = "BRL";
                }
                case 2 -> {
                    fromCurrency = "BRL";
                    toCurrency = "USD";
                }
                case 3 -> {
                    fromCurrency = "EUR";
                    toCurrency = "BRL";
                }
                case 4 -> {
                    fromCurrency = "BRL";
                    toCurrency = "EUR";
                }
                case 5 -> {
                    fromCurrency = "USD";
                    toCurrency = "EUR";
                }
                case 6 -> {
                    fromCurrency = "EUR";
                    toCurrency = "USD";
                }
                default -> {
                    System.out.println("Opção inválida!");
                    return;
                }
            }

            double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
            if (convertedAmount != -1) {
                System.out.printf("O valor convertido é: %.2f %s%n", convertedAmount, toCurrency);
            }
        } finally {
            scanner.close(); // Garante o fechamento do Scanner
        }
    }

    private static double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        try {
            // Montando a URL da API
            String url = API_URL + fromCurrency;

            // Criando o cliente HTTP e a requisição
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Enviando a requisição e obtendo a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parsing do JSON
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            double exchangeRate = jsonObject.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();

            // Calculando o valor convertido
            return amount * exchangeRate;
        } catch (Exception e) {
            System.out.println("Erro ao obter os dados da API: " + e.getMessage());
            return -1;
        }
    }
}
