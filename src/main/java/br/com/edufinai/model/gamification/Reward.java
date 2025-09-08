package br.com.edufinai.model.gamification;

import java.math.BigDecimal;
/**
 * Representa uma recompensa concedida ao usuário quando metas/desafios são cumpridos.
 * Pode ser simbólica ou possuir um valor associado (ex.: bônus de R$ 50).
 *
 * Responsabilidades:
 * - Descrever a recompensa e o valor atrelado (quando aplicável).
 * - Controlar se a recompensa já foi resgatada.
 */
public class Reward {
    private Long id;
    private Long userId;
    private String description;
    private BigDecimal value;
    private boolean redeemed;

    public Reward() {}

    public Reward(Long id, Long userId, String description, BigDecimal value) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.value = value;
        this.redeemed = false;
    }
    public Reward(String description, BigDecimal value) {
        this.id = null;
        this.userId = null;
        this.description = description;
        this.value = value;
        this.redeemed = false;
    }
    /**
     * Marca a recompensa como resgatada.
     * Retorna false caso já esteja resgatada.
     *
     * @return true se o resgate foi efetuado agora, false se já estava resgatada
     */
    public boolean redeem() {
        if (!redeemed) {
            this.redeemed = true;
            System.out.println("🏅 Recompensa resgatada: " + description);
            return true;
        }
        System.out.println("⚠️ Recompensa já foi resgatada.");
        return false;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean isRedeemed() {
        return redeemed;
    }

    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }

    @Override
    public String toString() {
        return "🏆 Reward: " + description +
                " | Value: R$" + value +
                " | Status: " + (redeemed ? "✅ Redeemed" : "❌ Not redeemed");
    }
}