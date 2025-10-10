# 🧠 RH Workstation

**RH Workstation** é um sistema completo de **gestão de recursos humanos**, desenvolvido em **Java**, que visa facilitar o gerenciamento de colaboradores, candidatos, vagas, folhas salariais e solicitações internas de forma organizada e eficiente.

---

## 🏗️ Estrutura do Projeto

O projeto segue uma arquitetura **em camadas**, garantindo melhor manutenção e escalabilidade:

```
src
└── main
    └── java
        └── org.rhworkstation
            ├── app              # Ponto de entrada da aplicação
            ├── connection       # Conexão com o banco de dados
            ├── context          # Contextos globais (cache e sessão)
            ├── controller       # Controladores principais da aplicação
            ├── dao              # Camada de acesso a dados (Data Access Object)
            ├── dto              # Objetos de transferência de dados
            ├── exception        # Tratamento de exceções personalizadas
            ├── model            # Modelos e enums da aplicação
            ├── service          # Camada de lógica de negócio
            ├── utils            # Funções utilitárias
            └── view             # Interface textual (mensagens, inputs e menus)
```

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java 22 (Corretto)**
- 🧱 **Maven** para gerenciamento de dependências
- 🗄️ **MySQL Connector** (integração com banco de dados)
- 💾 **DTO/DAO Pattern**
- 🧩 **MVC (Model-View-Controller)**

---

## ⚙️ Funcionalidades

- 👔 **Gestão de Colaboradores**  
  Cadastro, edição e visualização de funcionários da empresa.

- 🧾 **Folha Salarial**  
  Cálculo e exibição de informações salariais e descontos.

- 📝 **Controle de Faltas e Férias**  
  Registro de faltas e solicitações de férias.

- 💼 **Gestão de Vagas e Candidatos**  
  Criação e acompanhamento de vagas e candidatos.

- 🔐 **Sistema de Login**  
  Autenticação de usuários com diferentes perfis (Admin, Colaborador, Candidato).

---

## 💻 Como Executar o Projeto

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/RH_Workstation.git
   ```

2. **Abra o projeto em uma IDE (IntelliJ, Eclipse, VS Code com plugin Java)**  
   Certifique-se de que o **JDK 22+** está configurado corretamente.

3. **Configure o banco de dados MySQL**  
   - Crie um schema no banco  
   - Ajuste as credenciais no arquivo de conexão (`Conexao.java`)

4. **Execute a aplicação**  
   - Rode o arquivo `Main.java` localizado em `org.rhworkstation.app`

---

## 🧩 Padrões de Projeto Utilizados

- **DAO (Data Access Object):** separa a lógica de acesso a dados do restante da aplicação.  
- **DTO (Data Transfer Object):** facilita a transferência de dados entre camadas.  
- **Service Layer:** centraliza a lógica de negócio.  
- **MVC:** organiza a aplicação entre Model, View e Controller.

---

## 📂 Pacotes Principais

| Pacote | Função |
|--------|--------|
| `app` | Contém o ponto de entrada da aplicação |
| `connection` | Gerencia a conexão com o banco de dados |
| `controller` | Controla a interação entre as camadas |
| `dao` | Manipula os dados do banco |
| `dto` | Representa objetos de transporte de dados |
| `model` | Modelos e enums do domínio |
| `service` | Contém as regras de negócio |
| `view` | Exibe mensagens, menus e entradas de dados |

---

## 🧠 Autores

**Lorhan, Nicolas, Sara e Victor**  
📅 Projeto desenvolvido para fins acadêmicos e profissionais.


