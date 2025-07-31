import java.io.IOException; // Importa a classe de exceção para lidar com erros de entrada/saída (como escrita de arquivos).
import java.util.Scanner;   // Importa a classe Scanner para ler a entrada do usuário pelo console.

public class Principal {
    // Método principal, o ponto de partida da execução do programa.
    public static void main(String[] args) {
        // Cria uma instância de Scanner para ler do teclado (System.in).
        Scanner leitura = new Scanner(System.in);
        // Cria uma instância da classe que encapsula a lógica de consulta do CEP.
        ConsultaCep consultaCep = new ConsultaCep();

        // Pede ao usuário para digitar o CEP.
        System.out.println("Digite o número de CEP para consulta: ");
        // Lê a linha inteira digitada pelo usuário e armazena na variável 'cep'.
        // 'var' infere o tipo String automaticamente.
        var cep = leitura.nextLine();

        // Bloco 'try' para executar código que pode lançar exceções (erros).
        try {
            // Chama o método para buscar o endereço correspondente ao CEP fornecido.
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            // Imprime o objeto de endereço. Isso funciona bem se a classe Endereco tiver um método toString() sobreescrito.
            System.out.println(novoEndereco);

            // Cria uma instância da classe responsável por gerar o arquivo de saída.
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            // Chama o método para salvar o objeto 'novoEndereco' em formato JSON.
            gerador.salvaJson(novoEndereco);
            // Bloco 'catch' para capturar e tratar exceções específicas que possam ocorrer no bloco 'try'.
        } catch (RuntimeException | IOException e) {
            // Se uma RuntimeException (ex: erro de API) ou IOException (ex: erro ao escrever arquivo) ocorrer...
            // ...imprime a mensagem de erro da exceção para o usuário.
            System.out.println(e.getMessage());
            // Informa ao usuário que a aplicação será encerrada.
            System.out.println("Finalizando a aplicação");
        }
    }
}
