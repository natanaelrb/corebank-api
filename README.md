## 🏦 CoreBank API

Uma API backend para gerenciamento de contas bancárias, desenvolvida com Java e Spring Boot, focada em modelagem de domínio, regras de negócio e arquitetura profissional.

## 🚀 Funcionalidades Implementadas (V1)
## 👤 Cliente

- Cadastro de cliente
- Definição de tipo de cliente (PF / PJ)
- Email único no sistema

## 🏦 Conta

- Criação de conta vinculada a um cliente
- Definição de tipo de conta (Corrente / Poupança)
- Número de conta único
- Saldo inicial definido automaticamente

## 💰 Transação

- Registro de transações
- Tipos de transação:
    - Depósito
    - Saque
    - Transferência (estrutura preparada)
- Registro de data e hora da operação

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (ambiente de desenvolvimento)
- Lombok
- Maven

## 🧱 Arquitetura do Projeto

O projeto segue uma organização em camadas baseada em boas práticas de mercado:

```bash
com.natan.corebank
│
├── api                 # Controllers (camada de entrada)
├── domain
│   ├── model           # Entidades JPA
│   └── enums           # Tipos enumerados
├── service             # Regras de negócio (em evolução)
└── repository          # Acesso a dados (em implementação)
```
Separação clara entre:
- Camada de entrada (Controller)
- Regras de negócio (Service)
- Persistência (Repository)
- Modelo de domínio (Entities)

## 📋 Requisitos do Sistema

- Java 17 ou superior
- Maven
- IDE (IntelliJ recomendado)
- Git

## 🚀 Como Executar

1. Clone o repositório
2. 
```bash
</> Bash
git clone https://github.com/SEU_USUARIO/corebank-api.git
```

2. Entre na pasta do projeto
````bash
</> Bash 
cd corebank-api
````
3. Execute a aplicação
````bash
</> Bash
mvn spring-boot:run
````

4. A aplicação estará disponível em:
````bash
</> Código 
http://localhost:8080
````
## 🗄️ Banco de Dados

Ambiente de desenvolvimento utiliza:
- H2 Database (memória)
Console H2 disponível em:
````bash
</> Código 
http://localhost:8080/h2-console
````
## 📊 Estrutura Atual do Domínio

## Cliente

- id
- nome
- email
- password
- tipoCliente (ENUM)

## Conta

- id
- numero
- agencia
- saldo (BigDecimal)
- tipoConta (ENUM)
- relacionamento ManyToOne com Cliente

## Transacao

- id
- tipoTransacao (ENUM)
- valor (BigDecimal)
- data (LocalDateTime)
- relacionamento ManyToOne com Conta

## 🔄 Próximas Implementações

- Camada Service com regras de negócio
- Validação de saldo para saque
- Endpoints REST completos
- Transferência entre contas
- Tratamento global de exceções
- Autenticação e autorização com Spring Security
- Testes unitários

## 🎯 Objetivo do Projeto

- Este projeto tem como foco:
- Praticar arquitetura backend com Java
- Aplicar modelagem de domínio
- Implementar regras de negócio reais
- Construir um projeto sólido para portfólio

## 🚀 Evolução Planejada

- Futuras versões poderão incluir:
- Sistema multiusuário com autenticação JWT
- Banco de dados PostgreSQL
- Logs de auditoria
- Deploy em ambiente cloud
- Integração com frontend

## 📄 Licença

Projeto desenvolvido para fins educacionais e evolução profissional.
