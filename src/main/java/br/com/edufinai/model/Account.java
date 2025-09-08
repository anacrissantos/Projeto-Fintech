package br.com.edufinai.model;
/**
 * Classe abstrata que representa uma conta bancária genérica no sistema EduFinAI.
 * Define os atributos e comportamentos básicos que serão herdados pelas subclasses.
 *
 * Responsabilidades:
 * - Identificar a conta por meio de id e número.
 * - Controlar o saldo atual.
 * - Definir os contratos para operações de depósito e saque.
 *
 * Subclasses conhecidas:
 * - {@link CheckingAccount}
 * - {@link SavingsAccount}
 *
 * @author Ana
 * @version 1.0
 * @since 2025-09-07
 */
public abstract class Account {
    private Long id;
    private String number;
    protected double balance;

    /**
     * Construtor da conta bancária.
     *
     * @param id identificador único da conta
     * @param number número da conta (ex.: "001")
     * @param balance saldo inicial da conta
     */
    public Account(Long id, String number, double balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }

    /**
     * Realiza um depósito na conta.
     * Este método deve ser implementado pelas subclasses.
     *
     * @param amount valor a ser depositado
     */
    public abstract void deposit(double amount);

    /**
     * Realiza um saque na conta.
     * Este método deve ser implementado pelas subclasses.
     *
     * @param amount valor a ser sacado
     * @return true se o saque for realizado com sucesso, false caso contrário
     */
    public abstract boolean withdraw(double amount);

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    /**
     * Retorna o saldo atual da conta.
     * Diferente de {@link #checkBalance()}, este método é usado internamente
     * para leitura direta do campo de saldo.
     *
     * @return saldo atual
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Consulta o saldo da conta.
     * Funciona como um alias de {@link #getBalance()}, mas pode ser usado
     * em cenários de exibição ou relatórios para maior clareza.
     *
     * @return saldo atual
     */
    public double checkBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=R$ " + balance +
                '}';
    }
}