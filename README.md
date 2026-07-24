# Pedido Service

Microsserviço desenvolvido em **Java 21** e **Spring Boot** responsável pelo gerenciamento de pedidos.

Além das operações de CRUD, este serviço realiza comunicação com o **cliente-service** através do **Spring RestClient**, garantindo que um pedido só seja criado para clientes existentes.

O projeto foi desenvolvido seguindo boas práticas de desenvolvimento Backend, utilizando arquitetura em camadas, DTOs, MapStruct, Bean Validation, tratamento global de exceções e documentação automática com OpenAPI/Swagger.

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Spring RestClient
- MapStruct
- Bean Validation (Jakarta Validation)
- Lombok
- OpenAPI / Swagger
- Docker
- Maven

---

# Arquitetura

O projeto segue a arquitetura em camadas (Layered Architecture):

```
Controller
    │
    ▼
Service
    │
    ▼
Repository
    │
    ▼
Banco de Dados
```

Cada camada possui uma responsabilidade específica:

- **Controller:** recebe e responde às requisições HTTP.
- **Service:** concentra as regras de negócio.
- **Repository:** realiza o acesso ao banco de dados.
- **Entity:** representa as tabelas do banco.
- **DTO:** utilizado para entrada e saída de dados da API.
- **Mapper:** converte DTOs em entidades e vice-versa utilizando MapStruct.

---

# Comunicação entre Microsserviços

Antes de criar um pedido, o **pedido-service** consulta o **cliente-service** utilizando o **Spring RestClient**.

Fluxo simplificado:

```
Cliente

    │

POST /pedidos

    │

Pedido Service

    │

RestClient

    │

Cliente Service

    │

Cliente existe?

   ├── Sim → Pedido é criado
   └── Não → Exceção retornada
```

Essa validação garante que não sejam cadastrados pedidos para clientes inexistentes.

---

# Funcionalidades

- Cadastro de pedidos
- Listagem paginada de pedidos
- Busca de pedido por ID
- Atualização de pedidos
- Exclusão de pedidos
- Atualização do status do pedido
- Validação da existência do cliente antes da criação do pedido
- Validação dos dados recebidos
- Tratamento global de exceções
- Documentação automática com Swagger/OpenAPI

---

# Estrutura do Projeto

```
src
└── main
    ├── config
    ├── controller
    ├── dto
    ├── entity
    ├── exception
    ├── mapper
    ├── repository
    ├── service
    └── client
```

---

# Como executar o projeto

## 1. Clone o repositório

```bash
git clone <https://github.com/YuriiFreitass/pedido-service>
```

---

## 2. Configure as variáveis de ambiente

Crie um arquivo `.env` baseado no arquivo `.env.example`.

---

## 3. Inicie o banco de dados

```bash
docker compose up -d
```

---

## 4. Certifique-se de que o cliente-service esteja em execução

Este microsserviço depende do **cliente-service** para validar a existência dos clientes.

---

## 5. Execute a aplicação

Utilizando Maven:

```bash
./mvnw spring-boot:run
```

Ou execute diretamente pela sua IDE.

---

# Banco de Dados

O projeto utiliza **MySQL** como banco de dados relacional.

As configurações da aplicação são realizadas através do arquivo:

```
application.yml
```

utilizando variáveis de ambiente.

---

# Documentação da API

Após iniciar a aplicação, acesse:

```
http://localhost:8081/swagger-ui/index.html
```

> **Observação:** ajuste a porta conforme a configuração do seu projeto.

---

# Endpoints

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| GET | `/v1/pedidos` | Lista pedidos |
| GET | `/v1/pedidos/{id}` | Busca pedido por ID |
| POST | `/v1/pedidos` | Cadastra pedido |
| PUT | `/v1/pedidos/{id}` | Atualiza pedido |
| PATCH | `/v1/pedidos/{id}/status` | Atualiza o status do pedido |
| DELETE | `/v1/pedidos/{id}` | Remove pedido |

---

# Regras de Negócio

- Um pedido só pode ser criado para um cliente existente.
- O cliente é validado através de comunicação entre microsserviços utilizando **Spring RestClient**.
- O status do pedido é controlado por meio de um **enum**.
- O status pode ser atualizado através de um endpoint específico.

---

# Boas práticas aplicadas

- Arquitetura em camadas (Layered Architecture)
- Comunicação entre microsserviços
- Spring RestClient
- Separação entre Entity e DTO
- MapStruct para mapeamento entre objetos
- Bean Validation para validação dos dados
- Tratamento global de exceções
- Código organizado seguindo princípios de Clean Code
- Documentação automática com OpenAPI/Swagger

---

# Melhorias futuras

- Spring Security
- Autenticação com JWT
- API Gateway
- Service Discovery
- Testes de integração entre microsserviços
- Mensageria com RabbitMQ
- CI/CD
- Deploy em ambiente cloud

---

# Autor

Desenvolvido por **Yuri Freitas** como projeto de estudos para aprofundamento em Java Backend utilizando Spring Boot, arquitetura de microsserviços e boas práticas de desenvolvimento.
