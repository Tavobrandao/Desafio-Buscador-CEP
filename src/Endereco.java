/**
 * Representa um modelo de dados para um endereço.
 * Utiliza o recurso 'record' do Java para criar uma classe de dados imutável de forma concisa.
 * O compilador gera automaticamente o construtor, getters, toString(), equals() e hashCode().
 * @param cep          O Código de Endereçamento Postal.
 * @param logradouro   O nome da rua, avenida, praça, etc.
 * @param complemento  Informações adicionais como número, bloco, apartamento.
 * @param localidade   A cidade.
 * @param uf           A sigla da Unidade Federativa (estado).
 */
public record Endereco(String cep, String logradouro, String complemento, String localidade, String uf) {
    // O corpo está vazio porque o compilador Java gera todos os métodos necessários
    // para esta classe de dados (construtor, acessores, toString, etc.).
}