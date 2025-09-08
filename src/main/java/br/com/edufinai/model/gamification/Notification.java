package br.com.edufinai.model.gamification;

import java.time.LocalDateTime;
/**
 * Representa uma notificação gerada pela gamificação
 * (ex.: "Meta alcançada", "Desafio concluído").
 *
 * Responsabilidades:
 * - Armazenar mensagem, data/hora e status de leitura.
 */
public class Notification {
    private Long id;
    private Long userId;
    private String message;
    private LocalDateTime timestamp;
    private boolean read;

    public Notification() {}

    public Notification(String message) {
        this.message = message;
    }
    public Notification(Long id, Long userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.read = false;
    }
    /**
     * Marca a notificação como lida.
     * Útil para evitar reexibição em interfaces.
     */
    public void markAsRead() {
        this.read = true;
    }

    // Getters and setters
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return (read ? "📨 [Lida]" : "📬 [Nova]") + " " + timestamp + " - " + message;
    }
}