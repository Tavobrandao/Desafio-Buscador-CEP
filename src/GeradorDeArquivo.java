// Importa as classes da biblioteca Google Gson para manipulação de JSON.
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// Importa classes para escrita de arquivos e tratamento de erros de I/O (Input/Output).
import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    /**
     * Salva um objeto Endereco em um arquivo .json.
     * @param endereco O objeto de endereço a ser serializado e salvo.
     * @throws IOException Se ocorrer um erro durante a escrita do arquivo.
     */
    public void salvaJson(Endereco endereco) throws IOException {
        // Cria uma instância de Gson com formatação "bonita" (indentação e quebras de linha).
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        // Cria um objeto para escrever no arquivo. O nome do arquivo será o CEP do endereço.
        // Ex: "01001000.json"
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");

        // 1. Converte o objeto 'endereco' para uma String no formato JSON.
        // 2. Escreve essa String JSON no arquivo.
        escrita.write(gson.toJson(endereco));

        // Fecha o escritor de arquivo. É crucial para salvar as alterações e liberar o recurso.
        escrita.close();
    }
}