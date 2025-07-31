import com.google.gson.Gson; // Biblioteca para converter JSON para Objeto Java e vice-versa.
import java.net.URI; // Classe para representar um endereço de recurso (URL).
import java.net.http.HttpClient; // Cliente moderno do Java para fazer requisições HTTP.
import java.net.http.HttpRequest; // Representa uma requisição HTTP a ser enviada.
import java.net.http.HttpResponse; // Representa a resposta recebida de uma requisição.

public class ConsultaCep {

    /**
     * Busca um endereço a partir de um CEP, consultando a API ViaCEP.
     * @param cep O CEP a ser consultado (somente números).
     * @return Um objeto Endereco preenchido com os dados.
     */
    public Endereco buscaEndereco(String cep) {
        // Monta a URI completa para a chamada da API, concatenando o CEP recebido.
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        // Cria uma instância de HttpClient (cliente HTTP).
        // NOTA: Esta instância é criada mas não usada. A linha no 'try' cria outra.
        HttpClient client = HttpClient.newHttpClient();

        // Constrói a requisição HTTP, especificando a URI de destino.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        // Envolve a chamada de rede em um bloco try-catch para lidar com possíveis falhas.
        try {
            // Envia a requisição e obtém a resposta.
            // O corpo da resposta é solicitado como uma String.
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Usa o Gson para converter a String JSON (response.body()) em um objeto da classe Endereco.
            return new Gson().fromJson(response.body(), Endereco.class);

            // Captura qualquer exceção que possa ocorrer durante a requisição.
        } catch (Exception e) {
            // Lança uma nova exceção de tempo de execução com uma mensagem amigável.
            // Isso esconde os detalhes técnicos do erro e simplifica o tratamento na classe Principal.
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }
}