# Desafio: Consulta de Endereço por CEP

![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-brightgreen)

Este projeto é uma aplicação de linha de comando (CLI) desenvolvida em Java como um desafio do curso de Java pela Alura. A aplicação permite ao usuário consultar um endereço completo a partir de um CEP (Código de Endereçamento Postal), utilizando a API pública [ViaCEP](https://viacep.com.br/).

## Funcionalidades

- `Interação via Console:` O usuário insere o CEP diretamente no terminal.
- `Consulta em Tempo Real:` Conecta-se à API do ViaCEP para buscar os dados mais recentes.
- `Exibição de Resultados:` Mostra o endereço formatado no console após a consulta.
- `Geração de Arquivo:` Salva os dados do endereço consultado em um arquivo `.json` formatado.
- `Nomenclatura Dinâmica:` O arquivo gerado é nomeado com o próprio CEP consultado (ex: `01001000.json`).
- `Tratamento de Erros:` Lida com CEPs inválidos e possíveis falhas de comunicação com a API.

## Tecnologias Utilizadas

- **Liguagem:** [Java 21](https://www.oracle.com/java/technologies/downloads/#java21)
- **Biblioteca:** [Google Gson](https://github.com/google/gson?tab=readme-ov-file) para manipulação de JSON.
- **API:** [ViaCEP](https://viacep.com.br/) para consulta de endereços.
- **Cliente HTTP:** Módulo `java.net.http.HttpClient` nativo do Java.

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou supeior.
- [Git](https://git-scm.com/) (para clonar o repositório).

## Como Executar o Projeto

Como este projeto não utiliza uma ferramenta de build como Maven ou Gradle, a dependência do Gson precisa ser gerenciada manualmente.

1. **Clone o repositório:**

```bash
git clone [htttps://github.com/Tavobrandao/Desafio-Buscador-CEP.git]
cd Desafio-Buscador-CEP
```

2. **Baixe a biblioteca Gson:**

- Faça o download do arquivo `.jar` da biblioteca Gson. Você pode encontrá-lo no [Maven Central Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson).

- Vá até a pasta Project Structure e abra o arquivo jar em uma pasta chamada `dependencies` e coloque o arquivo gson-2.10.1.jar dentro dela.

3. **Interaja com o programa:**

- O terminal irá pedir para você digitar um CEP. Após digitar e pressionar Enter, o endereço será exibido e um arquivo JSON será criado na pasta do projeto.

Dica: É mais fácil executar o projeto em uma IDE como IntelliJ IDEA ou Eclipse, que gerencia as dependências automaticamente para você.

## Estrutura do Projeto

O código foi organizado seguindo o Princípio da Responsabilidade Única (SRP), onde cada classe tem um papel bem definido:

- **Principal.java:** Ponto de entrada da aplicação. Orquestra o fluxo de execução, lida com a entrada do usuário e chama as outras classes.

- **ConsultaCep.java:** Classe de serviço responsável por se comunicar com a API ViaCEP e buscar os dados do endereço.

- **Endereco.java:** Um record que serve como modelo de dados (DTO) para armazenar as informações do endereço de forma imutável.

- **GeradorDeArquivo.java:** Classe responsável por pegar o objeto Endereco e salvá-lo como um arquivo JSON formatado.

## Autor
[Gustavo Brandão](https://www.linkedin.com/in/gustavobrandaobr/).