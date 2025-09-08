package br.com.edufinai.model.gamification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Motor de gamificação do EduFinAI.
 *
 * Responsabilidades:
 * - Registrar metas e desafios ativos.
 * - Avaliar progresso com base em saldos/projeções.
 * - Gerar recompensas e notificações.
 *
 * Fluxo típico:
 * - Adicionar metas e desafios.
 * - Processar progresso (saldo projetado).
 * - Consultar notificações e recompensas geradas.
 *
 * @see Goal
 * @see Challenge
 * @see Reward
 * @see Notification
 */
public class GamificationEngine {

    private List<Goal> goals;
    private List<Challenge> challenges;
    private List<Reward> rewards;
    private List<Notification> notifications;

    public GamificationEngine() {
        this.goals = new ArrayList<>();
        this.challenges = new ArrayList<>();
        this.rewards = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    /**
     * Adiciona uma nova meta ao motor.
     *
     * @param goal meta a ser adicionada
     */
    public void addGoal(Goal goal) {
        goals.add(goal);
        notifications.add(new Notification("Nova meta adicionada: " + goal.getTitle()));
    }

    /**
     * Avalia todas as metas cadastradas com base no saldo informado
     * e atualiza o estado de gamificação.
     *
     * Regras:
     * - Para cada {@link Goal}, chama {@link Goal#checkIfAchieved(java.math.BigDecimal)} passando o saldo.
     * - Se a meta for atingida, cria uma {@link Reward} de valor fixo (100,00)
     *   com a descrição "Meta Alcançada: <título>" e adiciona à lista de recompensas.
     * - Gera também uma {@link Notification} textual correspondente.
     *
     * Observações:
     * - Possui efeitos colaterais: modifica as listas internas de recompensas e notificações.
     * - Se executado repetidamente para o mesmo saldo sem controle externo,
     *   pode gerar recompensas/notificações duplicadas.
     *
     * @param currentBalance saldo atual ou projetado utilizado na verificação das metas
     */
    public void checkGoalsProgress(BigDecimal currentBalance) {
        for (Goal goal : goals) {
            if (goal.checkIfAchieved(currentBalance)) {
                Reward reward = new Reward("Meta Alcançada: " + goal.getTitle(),
                                                        new BigDecimal("100.00"));
                rewards.add(reward);
                notifications.add(new Notification("🎉 " + reward.getDescription()));
            }
        }
    }

    /**
     * Adiciona um novo desafio ao motor.
     *
     * @param challenge desafio a ser adicionado
     */
    public void addChallenge(Challenge challenge) {
        challenges.add(challenge);
        notifications.add(new Notification("Novo desafio iniciado: " + challenge.getTitle()));
    }
    /**
     * Verifica o status dos desafios (janelas de tempo, valores) e
     * atualiza o campo de conclusão quando aplicável.
     */
    public void checkChallengesStatus() {
        for (Challenge challenge : challenges) {
            if (challenge.isCompleted()) {
                notifications.add(new Notification("📅 Desafio em andamento: " + challenge.getTitle()));
            }
        }
    }

    /**
     * Retorna a lista de recompensas concedidas até o momento.
     * Útil para exibir em relatórios ou dashboards.
     *
     * @return lista de recompensas
     */
    public List<Reward> getRewards() {
        return rewards;
    }
    /**
     * Retorna a lista de notificações geradas.
     * Pode ser usada para exibir histórico ao usuário.
     *
     * @return lista de notificações
     */
    public List<Notification> getNotifications() {
        return notifications;
    }
    /**
     * Limpa as notificações pendentes.
     * Útil após exibição em interfaces para evitar repetição.
     */
    public void clearNotifications() {
        notifications.clear();
    }

    public void printStatus() {
        System.out.println("🏆 Metas:");
        goals.forEach(System.out::println);
        System.out.println("\n🎯 Desafios:");
        challenges.forEach(System.out::println);
        System.out.println("\n🎁 Recompensas:");
        rewards.forEach(System.out::println);
        System.out.println("\n🔔 Notificações:");
        notifications.forEach(System.out::println);
    }
}