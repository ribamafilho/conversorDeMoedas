# Conversor de Moedas

## Visão Geral
Este aplicativo Java é um programa simples de linha de comando para converter valores de moeda usando taxas de câmbio em tempo real da [ExchangeRate-API](https://www.exchangerate-api.com/). Os usuários podem escolher entre opções de conversão de moeda predefinidas e inserir o valor que desejam converter.

## Funcionalidades
- Converte valores de moeda entre USD, BRL e EUR.
- Taxas de câmbio em tempo real obtidas via API.
- Interface amigável para selecionar opções de conversão.

## Pré-requisitos
- **Java Development Kit (JDK)**: Versão 11 ou superior.
- Conexão com a internet para acessar a ExchangeRate-API.
- Uma chave válida da ExchangeRate-API (substitua o valor no código pela sua chave).

## Instalação
1. Clone o repositório ou baixe o código-fonte.
2. Certifique-se de que o JDK 11 ou superior esteja instalado.
3. Substitua a chave da API na constante `API_URL` pela sua chave pessoal da ExchangeRate-API:

```java
private static final String API_URL = "https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/";
```

4. Compile o programa Java:

```bash
javac CurrencyConverter.java
```

5. Execute o programa:

```bash
java CurrencyConverter
```

## Uso
1. Execute o programa no terminal.
2. Siga as instruções para selecionar uma das seguintes opções de conversão de moeda:
   - USD para BRL
   - BRL para USD
   - EUR para BRL
   - BRL para EUR
   - USD para EUR
   - EUR para USD
3. Insira o valor a ser convertido.
4. O programa buscará a taxa de câmbio em tempo real e exibirá o valor convertido.

### Exemplo
#### Entrada:
```
Bem-vindo ao Conversor de Moedas!
Escolha uma das opções abaixo:
1. USD para BRL
2. BRL para USD
3. EUR para BRL
4. BRL para EUR
5. USD para EUR
6. EUR para USD
Digite o número da sua escolha: 1
Digite o valor a ser convertido: 100
```

#### Saída:
```
O valor convertido é: 525.00 BRL
```

(Nota: A taxa de câmbio real variará dependendo dos dados da API em tempo real.)

## Estrutura do Código
- **Método Principal (main)**:
  - Fornece uma interface para o usuário selecionar as opções de conversão de moeda e inserir o valor.
- **Método convertCurrency**:
  - Lida com a requisição à API, faz o parsing da resposta e calcula o valor convertido.

## Dependências
- [Gson](https://github.com/google/gson): Usado para fazer o parsing das respostas JSON da API.

## Tratamento de Erros
- O aplicativo inclui tratamento básico de erros para cenários como entradas inválidas do usuário e erros na API.

## Limitações
- O programa suporta apenas as moedas USD, BRL e EUR.
- Requer uma conexão ativa com a internet para buscar taxas de câmbio.
- Limitações da ExchangeRate-API podem se aplicar dependendo da assinatura da sua chave de API.

## Licença
Este projeto é open-source e está disponível sob a licença MIT.

## Contribuição
Sinta-se à vontade para fazer um fork do repositório, realizar melhorias e enviar pull requests. Todas as contribuições são bem-vindas!

