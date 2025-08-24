package br.com.edufinai.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa uma transação financeira associada a uma conta e a uma categoria.
 * Na Etapa 1, a associação é realizada por IDs (accountId e categoryId).
 */
public class Transaction {
    private Long id;
    private Long accountId;
    private Long categoryId;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDate date;
    private String description;

    /**
     * Construtor padrão.
     */
    public Transaction() {
    }

    /**
     * Construtor completo.
     *
     * @param id          identificador único da transação
     * @param accountId   id da conta associada
     * @param categoryId  id da categoria associada
     * @param type        tipo da transação (INCOME/EXPENSE)
     * @param amount      valor positivo da transação
     * @param date        data da transação
     * @param description descrição detalhada
     */
    public Transaction(Long id, Long accountId, Long categoryId,
                       TransactionType type, BigDecimal amount,
                       LocalDate date, String description) {
        this.id = id;
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    /**
     * @return id da transação
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id define o id da transação
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return id da conta associada
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * @param accountId define a conta associada
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * @return id da categoria associada
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId define a categoria associada
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return tipo da transação (INCOME/EXPENSE)
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * @param type define o tipo da transação
     */
    public void setType(TransactionType type) {
        this.type = type;
    }

    /**
     * @return valor da transação
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount define o valor da transação (positivo)
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return data da transação
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date define a data da transação
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return descrição da transação
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description define a descrição da transação
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{id=" + id +
                ", accountId=" + accountId +
                ", categoryId=" + categoryId +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + "'}";
    }
}