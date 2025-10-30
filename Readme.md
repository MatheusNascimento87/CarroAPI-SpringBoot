# 🚗 CarroAPI - Spring Boot

Uma API REST desenvolvida com **Spring Boot** para gerenciar informações de carros, marcas e proprietários.  
O projeto foi criado com o objetivo de aplicar conceitos fundamentais de **Java**, **Spring Data JPA**, **validação com Jakarta Validation**, e **documentação com Swagger**.

---

## 🧩 Estrutura do Projeto

src/ <br>
└── main/<br>
└── java/<br>
└── carros/<br>
└── carroAPI/<br>
└── SpringBoot/<br>
├── controller/ # Controladores REST (Camada de exposição da API)<br>
├── service/ # Lógica de negócios<br>
├── entities/ # Entidades JPA (Modelos)<br>
└── repository/ # Interfaces de acesso ao banco de dados<br>
---

## ⚙️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
    - Spring Web
    - Spring Data JPA
    - Spring Validation (Jakarta)
- **Lombok**
- **Swagger / Springdoc OpenAPI**
- **PostgreSQL** (persistência de dados)
- **Maven**

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL em execução (com um banco de dados criado, por exemplo `carrosdb`)

### Passos para rodar localmente

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seuusuario/CarroAPI-SpringBoot.git

2. **Entre na pasta do projeto**
   ```bash
   cd CarroAPI-SpringBoot
3. **Configure o banco de dados no arquivo application.properties**
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/carrosdb
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
4. **Execute o projeto**
   ```bash
    mvn spring-boot:run
5. **Acesse a documentação Swagger**
   ```bash
    http://localhost:8080/swagger-ui.html
## 📚 Endpoints Principais
🔹 GET /carros/getAll

Retorna todos os carros cadastrados.

🔹 GET /carros/get/{id}

Retorna um carro específico pelo seu ID.

🔹 GET /carros/findByModelo?modelo=Fusca

Busca carros pelo modelo.

🔹 GET /carros/findByMarca?idMarca=1

Busca carros de uma marca específica.

🔹 GET /carros/findAcimaAno?ano=2015

Busca carros com ano acima do informado.

🔹 POST /carros/post

Cadastra um novo carro.
   ```bash

{
"modelo": "Onix",
"ano": 2022,
"marca": { "id": 1 },
"proprietarios": [
{ "id": 1 },
{ "id": 2 }
]
}
   ```
🔹 PUT /carros/update/{id}

Atualiza as informações de um carro existente.

🔹 DELETE /carros/delete/{id}

Remove um carro pelo ID.
## 🗃️ Entidades
### Carro

``id``: Long

``modelo``: String

``ano``: Integer

``marca``: Marca (ManyToOne)

proprietarios: List<Proprietarios> (ManyToMany)

### Marca

``id``: Long

``nome``: String

``carros``: List<Carro> (OneToMany)

### Proprietarios

``id``: Long

``nome``: String

``idade``: Integer

## 💡 Possíveis Melhorias Futuras

✅ Implementar testes unitários e de integração com JUnit e Mockito

🔒 Adicionar autenticação JWT usando Spring Security

🌐 Criar um front-end em AngularJS para consumir a API

☁️ Fazer deploy na AWS

🧩 Adicionar Docker para facilitar o deploy e execução

📈 Paginação e filtros avançados nos endpoints