package br.com.edufinai.model;

/**
 * Enumera os tipos de transações financeiras do sistema EduFinAI.
 *
 * Usado para classificar cada {@link br.com.edufinai.model.Transaction} como:
 * - Receita (entrada de dinheiro)
 * - Despesa (saída de dinheiro)
 * - Investimento (aplicação de valor para retorno futuro)
 */
public enum TransactionType {
    /**
     * Receita (entrada de valor), como salário ou bônus.
     */
    INCOME,

    /**
     * Despesa (saída de valor), como compras ou contas a pagar.
     */
    EXPENSE,

    /**
     * Investimento, como aportes em fundos ou renda fixa.
     */
    INVESTMENT
}
