# Projeto do Blog Cooperativo

Este é o repositório do projeto do Blog Cooperativo, uma aplicação web desenvolvida em Java Spring Boot. O objetivo do projeto é fornecer uma plataforma para manter uma linha do tempo com logs de um projeto em modo cooperativo. Os usuários podem criar posts, compartilhar atualizações e colaborar de forma eficiente.

## Funcionalidades

- Autenticação de usuários: Os usuários podem criar contas, fazer login e gerenciar suas informações pessoais.
- Criação de posts: Os usuários podem criar posts para documentar as atividades e atualizações do projeto.
- Linha do tempo: Os posts são organizados em uma linha do tempo para visualização ordenada das atividades do projeto.
- Gerenciamento de membros: Os administradores têm acesso a recursos adicionais para gerenciar membros, permissões e configurações do projeto.

## Tecnologias Utilizadas

- Java Spring Boot: Framework utilizado para o desenvolvimento da aplicação web.
- HTML/CSS: Linguagens de marcação e estilo para criação da interface do usuário.
- Thymeleaf: Biblioteca para renderização de templates HTML no servidor.
- Banco de Dados: Utilizamos o MySQL para armazenar os dados da aplicação.
- Spring Security: Biblioteca para autenticação e controle de acesso dos usuários.
- Spring Data JPA: Ferramenta de mapeamento objeto-relacional para interação com o banco de dados.
- Bootstrap: Framework CSS para facilitar a criação de interfaces responsivas.

## Configuração do Ambiente de Desenvolvimento

Para configurar o ambiente de desenvolvimento e executar o projeto localmente, siga as instruções abaixo:

1. Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.
2. Clone este repositório em seu ambiente de desenvolvimento local.
3. Configure o banco de dados MySQL e atualize as informações de conexão no arquivo `application.properties`.
4. Execute o comando `mvn spring-boot:run` para iniciar o servidor de desenvolvimento.
5. Acesse a aplicação em `http://localhost:8080` em seu navegador web.

## Contribuição

Se você deseja contribuir para este projeto, siga as diretrizes abaixo:

1. Faça um fork deste repositório e clone-o em seu ambiente local.
2. Crie um branch para suas alterações: `git checkout -b minha-branch`.
3. Faça as alterações desejadas e faça commit delas: `git commit -m 'Minhas alterações'`.
4. Envie as alterações para o seu repositório remoto: `git push origin minha-branch`.
5. Abra um pull request neste repositório original, descrevendo as alterações propostas.

