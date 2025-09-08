package br.com.edufinai.model;
/**
 * Representa uma conta corrente no sistema EduFinAI.
 * Permite depósitos e saques, considerando o uso de um limite adicional.
 *
 * Responsabilidades:
 * - Controlar saldo disponível e limite de crédito.
 * - Validar depósitos positivos.
 * - Autorizar saques dentro do saldo + limite.
 *
 * Exemplo de uso:
 * - Criar conta com saldo inicial de R$ 500,00 e limite de R$ 1000,00.
 * - Depositar valores positivos.
 * - Sacar valores que podem ultrapassar o saldo, desde que respeitem o limite.
 *
 * @see Account
 */
public class CheckingAccount extends Account {

    private double limit;

    /**
     * Construtor da conta corrente.
     *
     * @param id identificador único da conta
     * @param number número da conta
     * @param balance saldo inicial
     * @param limit limite de crédito disponível para saques
     */
    public CheckingAccount(Long id, String number, double balance, double limit) {
        super(id, number, balance);
        this.limit = limit;
    }

    /**
     * Realiza um depósito na conta corrente.
     * Apenas valores positivos são aceitos.
     *
     * @param amount valor a ser depositado
     */
    @Override
    public void deposit(double amount) {
        System.out.println("➡️ Tentativa de depósito: " + amount);
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Depósito de R$ " + amount + " realizado com sucesso.");
        } else {
            System.out.println("❌ Valor de depósito inválido.");
        }
    }

    /**
     * Realiza um saque da conta corrente.
     * O saque é autorizado se o valor não for negativo e estiver dentro do saldo + limite.
     *
     * @param amount valor a ser sacado
     * @return true se o saque for realizado, false caso contrário
     */
    @Override
    public boolean withdraw(double amount) {
        System.out.println("➡️ Tentativa de saque: " + amount + " | Saldo atual: " + balance + " | Limite: " + limit);
        if (amount > 0 && (balance + limit) >= amount) {
            balance -= amount;
            System.out.println("✅ Saque com limite de R$ " + amount + " realizado.");
            return true;
        } else {
            System.out.println("❌ Saque acima do limite permitido.");
            return false;
        }
    }

    /**
     * Retorna o limite de crédito disponível para saques além do saldo.
     *
     * @return valor do limite
     */
    public double getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return super.toString() + ", limit=R$ " + limit;
    }
}