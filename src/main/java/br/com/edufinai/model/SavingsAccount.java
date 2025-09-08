package br.com.edufinai.model;
/**
 * Representa uma conta poupança no sistema EduFinAI.
 * Permite depósitos, saques e aplicação de juros mensais sobre o saldo.
 *
 * Responsabilidades:
 * - Armazenar saldo e taxa de juros configurada.
 * - Validar depósitos positivos.
 * - Autorizar saques apenas dentro do saldo disponível.
 * - Atualizar o saldo aplicando juros ao final do período.
 *
 * Exemplo de uso:
 * - Criar conta poupança com saldo inicial de R$ 1500,00 e juros de 0,5% ao mês.
 * - Depositar valores adicionais.
 * - Aplicar juros mensais para simular rendimento.
 *
 * @see Account
 */
public class SavingsAccount extends Account {

    private double interestRate;

    /**
     * Construtor da conta poupança.
     *
     * @param id identificador único da conta
     * @param number número da conta
     * @param balance saldo inicial
     * @param interestRate taxa de juros mensal (ex.: 0.005 = 0,5% ao mês)
     */
    public SavingsAccount(Long id, String number, double balance, double interestRate) {
        super(id, number, balance);
        this.interestRate = interestRate;
    }

    /**
     * Realiza um depósito na conta poupança.
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
     * Realiza um saque da conta poupança.
     * O saque é autorizado somente se houver saldo suficiente.
     *
     * @param amount valor a ser sacado
     * @return true se o saque for realizado, false caso contrário
     */
    @Override
    public boolean withdraw(double amount) {
        System.out.println("➡️ Tentativa de saque: " + amount + " | Saldo atual: " + balance);
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("✅ Saque de R$ " + amount + " realizado.");
            return true;
        } else {
            System.out.println("❌ Saque acima do saldo disponível.");
            return false;
        }
    }

    /**
     * Aplica os juros mensais sobre o saldo da conta poupança.
     * A taxa de juros é definida no momento da criação da conta.
     */
    public void applyInterest() {
        double juros = balance * interestRate;
        balance += juros;
        System.out.println("💰 Juros aplicados: R$ " + juros + " | Novo saldo: R$ " + balance);
    }

    /**
     * Retorna a taxa de juros mensal configurada para esta conta.
     *
     * @return taxa de juros (ex.: 0.005 = 0,5% ao mês)
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Retorna uma representação textual da conta poupança,
     * incluindo saldo e taxa de juros.
     *
     * @return string formatada com saldo e taxa de juros
     */
    @Override
    public String toString() {
        return super.toString() + ", interestRate=" + (interestRate * 100) + "%";
    }
}