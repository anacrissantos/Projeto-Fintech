package br.com.edufinai.cli;

import br.com.edufinai.model.*;
import br.com.edufinai.service.GerenciadorFinanceiroService;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Ponto de entrada (CLI) para esta Etapa do projeto.
 * Permite validar o fluxo básico em memória sem banco de dados.
 */
public class App {
    /**
     * Executa um cenário de demonstração criando contas, categorias e transações.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        GerenciadorFinanceiroService service = new GerenciadorFinanceiroService();

        // Contas
        Account conta1 = new Account(1L, "Carteira");
        Account conta2 = new Account(2L, "Banco");
        service.adicionarAccount(conta1);
        service.adicionarAccount(conta2);

        // Categorias
        Category catSalario = new Category(10L, "Salário");
        Category catMercado = new Category(20L, "Mercado");
        service.adicionarCategory(catSalario);
        service.adicionarCategory(catMercado);

        // Transações
        service.adicionarTransaction(new Transaction(
                100L, 1L, 10L, TransactionType.INCOME,
                new BigDecimal("2000.00"), LocalDate.now(), "Salário do mês"
        ));
        service.adicionarTransaction(new Transaction(
                101L, 1L, 20L, TransactionType.EXPENSE,
                new BigDecimal("150.75"), LocalDate.now(), "Compras da semana"
        ));
        service.adicionarTransaction(new Transaction(
                102L, 2L, 20L, TransactionType.EXPENSE,
                new BigDecimal("89.90"), LocalDate.now(), "Padaria"
        ));

        // Saída de informações
        System.out.println("Contas: " + service.listarAccounts());
        System.out.println("Categorias: " + service.listarCategories());
        System.out.println("Transações: " + service.listarTransactions());
        System.out.println("Saldo Carteira: R$ " + service.calcularSaldoDaConta(1L));
        System.out.println("Saldo Banco: R$ " + service.calcularSaldoDaConta(2L));
    }
}