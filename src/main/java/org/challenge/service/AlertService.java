package org.challenge.service;

import org.challenge.AlertType;
import org.challenge.entity.Alert;
import org.challenge.entity.Topic;
import org.challenge.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlertService {
    private List<User> users;
    private List<Topic> topics;
    private List<Alert> alerts;

    public AlertService() {
        this.users = new ArrayList<>();
        this.topics = new ArrayList<>();
        this.alerts = new ArrayList<>();
    }

    // Registro de usuarios y temas
    public void registerUser(User user) {
        users.add(user);
    }

    //Registro de topico
    public void registerTopic(Topic topic) {
        topics.add(topic);
    }

    // Suscripción de usuarios a temas
    public void subscribeUserToTopic(User user, Topic topic) {
        user.subscribeToTopic(topic);
    }

    // Enviar alerta a todos los usuarios suscritos a un tema
    public void sendAlertToTopic(Alert alert, Topic topic) {
        for (User user : users) {
            if (user.getSubscribedTopics().contains(topic)) {
                user.addAlert(alert);
            }
        }
        alerts.add(alert);
    }

    // Enviar alerta a un usuario específico
    public void sendAlertToUser(Alert alert, User user) {
        user.addAlert(alert);
        alerts.add(alert);
    }

    // Obtener alertas no leídas y no expiradas para un usuario
    public List<Alert> getUnreadNonExpiredAlerts(User user) {
        return user.getAlerts().stream()
                .filter(alert -> !alert.isExpired())
                .sorted((a1, a2) -> {
                    if (a1.getType() != a2.getType()) {
                        return a1.getType() == AlertType.URGENTE ? -1 : 1;
                    }
                    return a1.getExpirationDate().compareTo(a2.getExpirationDate());
                })
                .collect(Collectors.toList());
    }

    // Obtener alertas no expiradas para un tema
    public List<Alert> getNonExpiredAlertsForTopic(Topic topic) {
        return alerts.stream()
                .filter(alert -> !alert.isExpired() && alert.isForAllUsers())
                .collect(Collectors.toList());
    }
}
