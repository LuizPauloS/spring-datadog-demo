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
export DD_API_KEY=your-datadog-api-key
