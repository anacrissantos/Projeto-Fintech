package br.com.edufinai.model.gamification;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
        * Representa uma meta financeira do usuário (ex.: juntar R$ 5000 para viagem).
        *
        * Responsabilidades:
        * - Guardar o valor-alvo e prazo (opcional).
        * - Indicar se a meta foi atingida.
        * - Verificar se o saldo projetado é suficiente para concluir a meta.
 */
public class Goal {
    private Long id;
    private Long userId;
    private String title;
    private BigDecimal targetAmount;
    private LocalDate deadline;
    private boolean achieved;

    public Goal() {}

    public Goal(Long id, Long userId, String title, BigDecimal targetAmount, LocalDate deadline) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
        this.achieved = false;
    }
    public Goal(String title, BigDecimal targetAmount) {
        this.id = null;
        this.userId = null;
        this.title = title;
        this.targetAmount = targetAmount;
        this.deadline = null;
        this.achieved = false;
    }
    /**
     * Verifica se a meta foi atingida comparando um saldo com o valor-alvo.
     * Atualiza o estado interno (achieved) conforme o resultado.
     *
     * @param currentBalance saldo considerado para a verificação (ex.: saldo projetado)
     * @return true se a meta foi atingida, false caso contrário
     */
    public boolean checkIfAchieved(BigDecimal currentBalance) {
        if (currentBalance.compareTo(targetAmount) >= 0) {
            this.achieved = true;
        }
        return achieved;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    @Override
    public String toString() {
        return "🎯 Goal: " + title +
                " | Target: R$" + targetAmount +
                " | Deadline: " + deadline +
                " | Status: " + (achieved ? "✅ Achieved" : "⌛ Pending");
    }
}