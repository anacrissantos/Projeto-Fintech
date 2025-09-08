package br.com.edufinai.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa uma transação financeira do usuário no EduFinAI.
 * Uma transação pode ser do tipo receita (INCOME), despesa (EXPENSE) ou investimento (INVESTMENT).
 *
 * Responsabilidades:
 * - Identificar o usuário, conta e categoria associados.
 * - Registrar valor, data e descrição.
 * - Definir o tipo da transação por meio do {@link TransactionType}.
 *
 * Exemplos de uso:
 * - Receita: salário mensal de R$ 3000,00.
 * - Despesa: gasto em restaurante de R$ 250,00.
 * - Investimento: aporte em fundo de ações.
 */
public class Transaction {
    private Long id;
    private Long userId;
    private Long accountId;
    private Long categoryId;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDate date;
    private String description;

    /**
     * Cria uma nova transação.
     *
     * @param id          identificador único da transação
     * @param userId      id do usuário dono da transação
     * @param accountId   id da conta associada
     * @param categoryId  id da categoria associada
     * @param type        tipo da transação (INCOME, EXPENSE ou INVESTMENT)
     * @param amount      valor monetário da transação
     * @param date        data em que ocorreu
     * @param description descrição breve (ex.: "Salário", "Restaurante")
     */
    public Transaction(Long id, Long userId, Long accountId, Long categoryId,
                       TransactionType type, BigDecimal amount, LocalDate date,
                       String description) {
        this.id = id;
        this.userId = userId;
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public TransactionType getType() {
        return type;
    }

    /**
     * Retorna o valor da transação.
     * Importante usar {@link BigDecimal} para evitar imprecisão em cálculos financeiros.
     *
     * @return valor monetário da transação
     */
    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    /**
     * Retorna a descrição textual da transação.
     * Pode ser usada em relatórios ou exibição em interfaces.
     *
     * @return descrição da transação
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retorna uma representação textual da transação,
     * incluindo tipo, valor e data.
     *
     * @return string formatada com os principais dados da transação
     */
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountId=" + accountId +
                ", categoryId=" + categoryId +
                ", type=" + type +
                ", amount=R$ " + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}