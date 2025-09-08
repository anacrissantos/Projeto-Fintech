package br.com.edufinai.cli;

import br.com.edufinai.model.*;
import br.com.edufinai.model.gamification.*;
import br.com.edufinai.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Aplicação de linha de comando (CLI) do EduFinAI.
 * Permite validar o fluxo básico em memória, sem banco de dados.
 *
 * Fluxo principal:
 * - Autentica um usuário de demonstração.
 * - Simula transações e imprime um relatório mensal.
 * - Processa gamificação (metas, desafios, notificações e recompensas).
 * - Simula operações bancárias (conta corrente e poupança).
 *
 * Boas práticas demonstradas:
 * - Separação de responsabilidades (service, model, gamification, cli).
 * - Uso de BigDecimal para valores monetários.
 * - Modularização do main em métodos auxiliares coesos.
 *
 * @author Ana
 * @version 2.0
 * @since 2025-09-07
 *
 * @see br.com.edufinai.service.GerenciadorFinanceiroService
 * @see br.com.edufinai.service.SimuladorFinanceiro
 * @see br.com.edufinai.model.Transaction
 * @see br.com.edufinai.model.gamification.GamificationEngine
 */
public class EduFinApp {
    /**
     * Executa o fluxo de demonstração da aplicação em linha de comando.
     * Não recebe argumentos nesta versão.
     *
     * Etapas:
     * - Instancia serviços e cria um usuário de exemplo.
     * - Autentica o usuário.
     * - Chama os cenários de transações, gamificação e contas.
     * - Exibe mensagens de sucesso ou falha.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        GerenciadorFinanceiroService service = new GerenciadorFinanceiroService();

        User user = new User();
        user.setId(1L);
        user.setName("Ana");
        user.setEmail("ana@email.com");
        user.setPassword("1234");

        boolean autenticado = user.authenticate("1234");

        if (autenticado) {
            System.out.println("✅ Usuário autenticado com sucesso.\n");

            simularTransacoes(service, user);
            processarGamificacao(service);
            simularContasBancarias();

            System.out.println("\n✔️ Processo concluído com sucesso!\n");

        } else {
            System.out.println("❌ Falha na autenticação.");
        }
    }

    /**
     * Simula o registro de transações financeiras do usuário e gera um relatório mensal.
     *
     * O que faz:
     * - Cria uma transação de despesa (ex.: restaurante).
     * - Cria uma transação de receita (ex.: salário).
     * - Registra as transações no {@link GerenciadorFinanceiroService}.
     * - Gera e imprime um relatório mensal consolidado.
     *
     * @param service instância do {@link GerenciadorFinanceiroService} responsável por gerenciar as transações
     * @param user usuário dono das transações simuladas
     */
    private static void simularTransacoes(GerenciadorFinanceiroService service, User user) {
        // Transação de despesa
        Transaction t1 = new Transaction(
                100L, user.getId(), 1L, 10L,
                TransactionType.EXPENSE,
                new BigDecimal("250.00"),
                LocalDate.of(2025, 9, 6),
                "Restaurante"
        );
        service.registerTransaction(t1);

        // Transação de receita
        Transaction t2 = new Transaction(
                101L, user.getId(), 1L, 20L,
                TransactionType.INCOME,
                new BigDecimal("3000.00"),
                LocalDate.of(2025, 9, 2),
                "Salário"
        );
        service.registerTransaction(t2);

        // Relatório mensal
        String relatorio = service.generateMonthlyReport(user);
        System.out.println(relatorio);
    }

    /**
     * Processa a lógica de gamificação a partir das transações financeiras registradas.
     *
     * O que faz:
     * - Obtém as transações via {@link GerenciadorFinanceiroService}.
     * - Projeta o saldo para 6 meses com {@link SimuladorFinanceiro}.
     * - Cria uma meta e um desafio de economia.
     * - Adiciona tudo ao {@link GamificationEngine} e verifica progresso e status.
     * - Imprime notificações e recompensas geradas.
     * - Exibe projeções: saldo projetado, saldo ajustado pela inflação e meses para atingir a meta.
     *
     * @param service instância do {@link GerenciadorFinanceiroService} que fornece as transações do usuário
     */
    private static void processarGamificacao(GerenciadorFinanceiroService service) {
        SimuladorFinanceiro simulador = new SimuladorFinanceiro();
        List<Transaction> transacoes = service.getTransacoes();
        BigDecimal saldoProjetado = simulador.projetarSaldoFuturo(transacoes, 6);

        Goal metaViagem = new Goal("Viagem para o Nordeste", new BigDecimal("5000"));
        Challenge desafioEconomia = new Challenge("Economizar R$500 este mês", new BigDecimal("500"));

        GamificationEngine engine = new GamificationEngine();
        engine.addGoal(metaViagem);
        engine.addChallenge(desafioEconomia);

        engine.checkGoalsProgress(saldoProjetado);
        engine.checkChallengesStatus();

        // Notificações
        System.out.println("\n🔔 Notificações:");
        for (Notification notification : engine.getNotifications()) {
            System.out.println("📢 " + notification.getMessage());
        }

        // Recompensas
        System.out.println("\n🎁 Recompensas:");
        if (engine.getRewards().isEmpty()) {
            System.out.println("🔸 Nenhuma recompensa atribuída ainda.");
        } else {
            for (Reward reward : engine.getRewards()) {
                System.out.println("🏅 " + reward.getDescription() + " | Valor: R$ " + reward.getValue());
            }
        }

        // Projeções financeiras
        System.out.println("\n🔮 Projeções:");
        System.out.println("📈 Saldo projetado para 6 meses: R$ " + saldoProjetado);

        BigDecimal saldoComInflacao = simulador.ajustarPorInflacao(saldoProjetado, 0.06, 6);
        System.out.println("📉 Saldo ajustado pela inflação: R$ " + saldoComInflacao);

        int mesesParaMeta = simulador.estimarMesesParaObjetivo(new BigDecimal("5000"), transacoes);
        System.out.println("🎯 Meses para atingir R$5000: " +
                (mesesParaMeta >= 0 ? mesesParaMeta + " meses" : "Não alcançável com saldo atual"));
    }

    /**
     * Simula operações básicas em contas bancárias e exibe os saldos resultantes.
     * O que faz:
     * - Cria uma conta corrente, realiza depósitos/saques (incluindo uso de limite) e imprime o saldo.
     * - Cria uma conta poupança, realiza depósito, aplica juros do mês e imprime o saldo.
     */
    private static void simularContasBancarias() {
        // Conta Corrente
        CheckingAccount cc = new CheckingAccount(1L, "001", 500.00, 1000.00);
        System.out.println("\n🏦 Conta Corrente criada: " + cc);

        cc.deposit(200.00);
        cc.withdraw(100.00);  // dentro do saldo
        cc.withdraw(800.00);  // uso do limite
        System.out.println("💼 Saldo atual Conta Corrente: R$ " + cc.checkBalance());

        // Conta Poupança
        SavingsAccount cp = new SavingsAccount(2L, "002", 1500.00, 0.005);
        System.out.println("\n💰 Conta Poupança criada: " + cp);

        cp.deposit(500.00);
        cp.applyInterest();
        System.out.println("💼 Saldo atual Conta Poupança: R$ " + cp.checkBalance());
    }
}