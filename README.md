# 💰 Projeto EduFinAI

![status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow) 
![java](https://img.shields.io/badge/java-21-blue)
![springboot](https://img.shields.io/badge/SpringBoot-3.3-brightgreen)
![maven](https://img.shields.io/badge/build-Maven-red)
![db](https://img.shields.io/badge/DB-Oracle-orange)
![license](https://img.shields.io/badge/licença-MIT-green)

---

## 📌 Sobre o Projeto
O **EduFinAI** é um sistema web desenvolvido para apoio ao **controle financeiro pessoal** com auxílio de inteligência artificial.  

O objetivo é integrar **Frontend + Backend + Banco de Dados** em uma aplicação que simula uma plataforma de gestão financeira, ajudando o usuário a organizar seus gastos, planejar orçamentos e melhorar sua educação financeira.  

---

## 🛠️ Tecnologias Utilizadas
- **Frontend:** HTML, CSS, JavaScript (com framework adicional no futuro)  
- **Backend:** Java 21 + Spring Boot 3.3  
- **Banco de Dados:** Oracle  
- **Build/Dependências:** Maven  
- **IDE:** IntelliJ IDEA Community Edition  

---

## 📖 Documentação JavaDoc
A documentação completa está publicada no GitHub Pages:  

👉 [**Acessar JavaDoc**](https://anacrissantos.github.io/Projeto-Fintech/)  

---

## 📂 Estrutura do Projeto
- `src/main/java/br/com/edufinai/model` → Entidades principais (usuário, conta, transação, categoria, investimento).  
- `src/main/java/br/com/edufinai/model/gamification` → Gamificação (metas, desafios, recompensas, notificações, motor).  
- `src/main/java/br/com/edufinai/service` → Serviços de gerenciamento financeiro e simulação.  
- `src/main/java/br/com/edufinai/cli` → Ponto de entrada via linha de comando.  

---

## ▶️ Exemplo de Uso
```java
User user = new User();
user.setName("Ana");
user.setEmail("ana@email.com");
user.setPassword("1234");

GerenciadorFinanceiroService service = new GerenciadorFinanceiroService();
Transaction t1 = new Transaction(...); // Receita ou despesa
service.registerTransaction(t1);

String relatorio = service.generateMonthlyReport(user);
System.out.println(relatorio);
```
---

## 🚀 Próximos Passos

- Criar endpoints para cadastro de usuários
- Conectar aplicação ao banco Oracle
- Desenvolver interface web inicial
- Implementar módulo de IA para recomendações financeiras

---

##  👩‍💻 Autores

Alex
Amanda
Ana Cristina
Bruno
Carolina

---

##  📜 Licença

Este projeto está sob a licença MIT.
Consulte o arquivo LICENSE para mais detalhes.

