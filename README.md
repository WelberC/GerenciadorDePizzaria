# Sistema de Pizzaria

Este é um projeto de um sistema de gerenciamento de pizzaria desenvolvido em **Java** com **Spring Boot** para o back-end, e **Banco de Dados Relacional** (MySQL) para o armazenamento de dados. 
O sistema tem como objetivo facilitar todo o gerenciamento de dados de uma pizzaria (recebimento de pedidos, acompanhamento, gestão de produtos, dentre outros)

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Framework para construção da API REST.
- **MySQL**: Banco de dados relacional.
- O projeto ainda está em desenvolvimento e passando por correções constantes, mas a ideia é criar também uma aplicação front-end em Angular para consumir a API. 

## Funcionalidades

### 1. **Gestão de Produtos**
- Cadastro, Pesquisa, Edição e remoção de produtos como **Pizzas**, **Esfihas**, **Bolos**, **Refrigerantes**, **Tortas**.
- Cada produto tem um nome, descrição, imagem, categoria e preço.

### 2. **Gestão de Pedidos**
- Criação de pedidos com produtos selecionados.
- O status do pedido pode ser alterado entre: **Recebido**, **Produção**, **Entregue**, **Cancelado** pelos usuários "admin" ou "cozinha".
- Relacionamento entre **Pedido** e **Produto**, onde cada pedido pode ter múltiplos produtos.

### 3. **Gestão de Usuários**
- Cadastro de usuários com diferentes **cargos** e **permissões**: **Cliente**, **Cozinha**, **Admin**.
- Funções distintas para cada usuário no sistema.
- Autenticação e autorização baseadas nos cargos do usuário.

### O projeto ainda está em desenvolvimento.
