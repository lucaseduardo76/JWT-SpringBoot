# **Spring Security com JWT (Bearer Token)**

## **Sobre o Projeto**
Este projeto tem como objetivo demonstrar o funcionamento do **Spring Security** utilizando **JWT (JSON Web Token)** como Bearer Token para autenticação e autorização de usuários. É ideal para estudo e entendimento dos conceitos de segurança em aplicações **Spring Boot**.

O projeto inclui:
- Cadastro de usuários com senhas criptografadas.
- Login de usuários para geração de tokens JWT.
- Proteção de endpoints com base em permissões (**roles**) de usuário.
- Validação de tokens JWT para acesso aos recursos protegidos.
- Implementação de sessão **stateless**.

---

## **Tecnologias Utilizadas**
- **Java 21** (OpenJDK 21 LTS)
- **Spring Boot** 3.x
- **Spring Security** (Autenticação e Autorização)
- **JWT** (JSON Web Token)
- **Maven** (Gerenciador de Dependências)
- **MySQL** (Banco de Dados Relacional)
- **Lombok** (Redução de Boilerplate)
- **MapStruct** (Conversão de DTOs)
- **BCrypt** (Criptografia de Senhas)

---

## **Funcionalidades**
- **Cadastro de Usuário**: Endpoint público para criar novos usuários.
- **Login de Usuário**: Endpoint público para autenticação de credenciais e geração de token JWT.
- **Autorizção**: 
    - Apenas usuários autenticados podem acessar os endpoints protegidos.
    - Diferenciação de permissões por **roles** (`ROLE_USER` e `ROLE_ADMIN`).
- **Validação de Token**: Filtragem do token JWT nas requisições.
- **Sessão Stateless**: Implementação de autenticação sem estado.

---

## **Pré-requisitos**
Antes de iniciar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:
- [Java 21 (LTS)](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/)
- Uma IDE como **IntelliJ** ou **Eclipse**.

---

## **Configuração do Projeto**

1. **Clonar o Repositório**
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   cd nome-do-repositorio
   ```

2. **Configurar o Banco de Dados**
   - Crie um banco de dados MySQL chamado `spring_jwt_db` (ou outro nome de sua preferência).
   - Atualize o arquivo `application.properties` com suas configurações:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/spring_jwt_db
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

   # Token JWT
   api.security.token.secret=umaChaveSecretaSegura
   ```

3. **Executar o Projeto**
   Compile e execute a aplicação usando o Maven:
   ```bash
   mvn spring-boot:run
   ```

   A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

---

## **Endpoints**

### **Endpoints Públicos**
1. **Cadastro de Usuário**
   - **URL**: `/auth/register`
   - **Método**: `POST`
   - **Body**:
     ```json
     {
       "username": "usuario",
       "password": "senha",
       "role": "USER"
     }
     ```

2. **Login**
   - **URL**: `/auth/login`
   - **Método**: `POST`
   - **Body**:
     ```json
     {
       "username": "usuario",
       "password": "senha"
     }
     ```
   - **Resposta**:
     ```json
     {
       "token": "jwt-token-gerado"
     }
     ```

### **Endpoints Protegidos**
3. **Endpoint Restrito a Usuários Autenticados**
   - **URL**: `/api/user`
   - **Método**: `GET`
   - **Header**:  
     ```http
     Authorization: Bearer <token_jwt>
     ```

4. **Endpoint Restrito a Administradores**
   - **URL**: `/api/admin`
   - **Método**: `POST`
   - **Header**:  
     ```http
     Authorization: Bearer <token_jwt>
     ```

---

## **Exemplo de Uso do Token**
1. **Obter Token**: Faça login utilizando o endpoint `/auth/login`.
2. **Enviar Token**: Ao acessar um endpoint protegido, adicione o token no **header**:
   ```http
   Authorization: Bearer <seu_token_jwt>
   ```

---

## **Fluxo de Funcionamento**
1. **Cadastro**: O usuário realiza o cadastro no sistema.
2. **Login**: O sistema autentica as credenciais e retorna um token JWT.
3. **Autorizção**:  
   - O token é validado em cada requisição protegida.
   - O Spring Security verifica as permissões com base nas roles (`ROLE_USER` ou `ROLE_ADMIN`).
4. **Proteção**: O token expira após um período configurado (2 horas).

---

## **Segurança Implementada**
- **Criptografia de Senha**: As senhas são armazenadas no banco de dados de forma criptografada usando `BCrypt`.
- **JWT**: Garante que apenas usuários autenticados acessem os endpoints protegidos.
- **Stateless**: A autenticação é sem estado, ou seja, não há armazenamento de sessão no servidor.

---

## **Testando a Aplicação**

Você pode utilizar ferramentas como **Postman** ou **Insomnia** para testar os endpoints.

1. **Cadastrar um Usuário**.
2. **Logar com o Usuário** para obter o token JWT.
3. **Acessar Endpoints Protegidos** utilizando o token JWT no cabeçalho.

