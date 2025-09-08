package br.com.edufinai.model.gamification;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa um desafio de curto prazo para estimular hábitos financeiros
 * (ex.: economizar R$ 500 neste mês).
 *
 * Responsabilidades:
 * - Definir título, descrição, janela de tempo (início/fim) e valor a alcançar.
 * - Indicar se o desafio foi concluído.
 *
 * Observações:
 * - A regra de conclusão é definida pelo motor de gamificação,
 *   que avalia o progresso ao longo do período ativo.
 */
public class Challenge {

    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal value; // novo atributo
    private boolean completed;

    // Construtor padrão
    public Challenge() {}

    // Construtor completo
    public Challenge(Long id, String title, String description, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.completed = false;
    }

    // Construtor simplificado para testes e exemplos
    public Challenge(String title, BigDecimal value) {
        this.title = title;
        this.description = "Desafio automático para economia de valor.";
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.now().plusMonths(1);
        this.value = value;
        this.completed = false;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}