# Atividade Lojinha

Projeto desenvolvido para a disciplina de Arquitetura de Software, com o objetivo de simular o funcionamento de uma lojinha online em uma arquitetura cliente-servidor monolítica.

## Estrutura do projeto

O projeto está organizado na pasta `src`, dividida da seguinte forma:

- `src/model`  
  Contém as classes de domínio do sistema, como cliente, produto, pedido, item do pedido e pagamento.

- `src/repository`  
  Contém os repositórios responsáveis por disponibilizar dados do sistema, como clientes e produtos cadastrados.

- `src/service`  
  Contém as regras de negócio e os serviços principais do sistema, incluindo a lógica da loja e a comunicação com o sistema externo de pagamento.

- `src/Main.java`  
  Classe principal responsável por executar a simulação do sistema.

## Principais decisões arquiteturais

O sistema foi desenvolvido seguindo uma arquitetura monolítica no modelo cliente-servidor, conforme solicitado na atividade. Todas as responsabilidades do backend estão centralizadas em uma única aplicação.

As principais decisões arquiteturais foram:

- separação do código em camadas simples (`model`, `repository` e `service`) para melhorar a organização;
- uso de classes de modelo para representar as entidades principais do sistema;
- uso de repositórios estáticos para simular dados previamente cadastrados;
- centralização das regras de negócio na classe de serviço principal da loja;
- simulação do processamento de pagamento por meio de um serviço externo específico.

## Aplicação do padrão Singleton

O padrão de projeto Singleton foi aplicado na classe responsável pela comunicação com o sistema externo de pagamento.

A classe `PagamentoExternoService` foi implementada como Singleton para garantir que exista apenas uma única instância desse serviço durante toda a execução do programa.

Essa decisão foi adotada porque o sistema externo de pagamento representa um recurso compartilhado, e faz sentido que a aplicação utilize apenas uma conexão lógica centralizada para esse serviço.

Com isso, o projeto evita a criação desnecessária de múltiplas instâncias para o mesmo componente, garantindo maior controle e consistência no processamento dos pagamentos.
