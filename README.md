# Spring Datadog Demo

Este projeto é uma aplicação Spring Boot configurada para monitoramento com o Datadog.

## Pré-requisitos

Certifique-se de ter os seguintes itens instalados em sua máquina:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 17](https://adoptium.net/temurin/releases/)
- [Gradle](https://gradle.org/) (opcional, pois o wrapper está incluído)

Além disso, você precisará de uma API Key do Datadog. Realize o registro no [portal do Datadog](https://www.datadoghq.com/) e com a chave em mãos configure-a como uma variável de ambiente:

```bash
export DATADOG_API_KEY=your-datadog-api-key
```

## Como rodar o projeto

1. Construir o JAR da aplicação
Antes de rodar o projeto, é necessário construir o JAR da aplicação. Execute o seguinte comando:

```bash
./gradlew build
```

Isso irá gerar o arquivo JAR em build/libs.

2. Subir os containers com Docker Compose
Com o JAR construído, você pode subir os containers da aplicação e do Datadog Agent:

```bash
docker-compose up --build
```

3. Acessar a aplicação
A aplicação estará disponível em http://localhost:8080.

Exemplo curl listar pedidos:

```bash
curl --request GET \
  --url http://localhost:8080/pedidos \
```

4. Verificar os logs e métricas no Datadog
Certifique-se de que sua API Key do Datadog está configurada corretamente. Você poderá visualizar os logs, métricas e traces no painel do Datadog.

Configurações adicionais
Variáveis de ambiente
Você pode ajustar as variáveis de ambiente no arquivo docker-compose.yml para personalizar o comportamento da aplicação e do Datadog Agent.

Rede
Os serviços estão configurados para usar a rede datadog-net. Certifique-se de que não há conflitos com outras redes Docker.

Limpar os containers
Para parar e remover os containers, execute:

```bash
docker-compose up --build
```
