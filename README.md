# 🛒 Atividade Lojinha

Projeto desenvolvido para a disciplina de Arquitetura de Software, com o objetivo de simular o funcionamento de uma lojinha online utilizando uma arquitetura cliente-servidor monolítica.

---

## 📌 Objetivo

O sistema simula as principais operações de uma loja online, incluindo:

- identificação de clientes;
- listagem de produtos;
- criação de pedidos;
- processamento de pagamentos;
- comunicação com um sistema externo de pagamento.

---

## 🏗️ Estrutura do projeto

O projeto está organizado na pasta `src`, dividida da seguinte forma:

- `src/model`  
  Contém as classes de domínio do sistema, como:
  - Cliente  
  - Produto  
  - Pedido  
  - ItemPedido  
  - Pagamento  

- `src/repository`  
  Responsável por simular o armazenamento e disponibilização de dados, como clientes e produtos cadastrados.

- `src/service`  
  Contém as regras de negócio do sistema, incluindo:
  - lógica da loja  
  - criação de pedidos  
  - integração com o sistema de pagamento  

- `src/Main.java`  
  Classe principal responsável por executar a simulação do sistema.

---

## ⚙️ Principais decisões arquiteturais

O sistema foi desenvolvido seguindo uma arquitetura **cliente-servidor monolítica**, onde todas as responsabilidades estão centralizadas em uma única aplicação backend.

As principais decisões foram:

- separação em camadas (`model`, `repository` e `service`) para melhor organização;
- uso de classes de modelo para representar as entidades do sistema;
- utilização de repositórios estáticos para simular dados persistidos;
- centralização das regras de negócio na camada de serviço;
- simulação da comunicação com um sistema externo de pagamento.

---

## 🔁 Diagramas do sistema

Os diagramas desenvolvidos para o projeto estão disponíveis na pasta `docs` do repositório:

- Diagrama de Atividades  
- Diagrama Entidade-Relacionamento (DER)

---

## 🧠 Aplicação do padrão Singleton

O padrão de projeto **Singleton** foi aplicado na classe responsável pela comunicação com o sistema externo de pagamento.

A classe `PagamentoExternoService` foi implementada como Singleton para garantir que exista apenas uma única instância desse serviço durante toda a execução do programa.

### ✔️ Justificativa

Essa decisão foi adotada porque:

- o sistema de pagamento representa um recurso compartilhado;
- não faz sentido criar múltiplas conexões para o mesmo serviço;
- garante maior controle e consistência no processamento dos pagamentos;
- evita consumo desnecessário de recursos.

---

## 📚 Tecnologias utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Padrão de Projeto Singleton
- Modelagem UML (Diagrama de Atividades e DER)

