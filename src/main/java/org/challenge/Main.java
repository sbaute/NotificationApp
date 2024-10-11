package org.challenge;

import org.challenge.entity.Alert;
import org.challenge.entity.Topic;
import org.challenge.entity.User;
import org.challenge.service.AlertService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        AlertService service = new AlertService();

        // Crear usuarios y temas
        User alice = new User("Alice");
        User bob = new User("Bob");
        Topic news = new Topic("News");
        Topic sports = new Topic("Sports");

        // Registrar usuarios y temas
        service.registerUser(alice);
        service.registerUser(bob);
        service.registerTopic(news);
        service.registerTopic(sports);

        // Suscribir usuarios a temas
        service.subscribeUserToTopic(alice, news);
        service.subscribeUserToTopic(bob, sports);

        // Enviar alertas
        Alert urgentAlert = new Alert("Urgente noticia!", AlertType.URGENTE, LocalDateTime.now().plusDays(1), true, null);
        service.sendAlertToTopic(urgentAlert, news);

        Alert infoAlert = new Alert("Actualización deportiva", AlertType.INFORMATIVA, LocalDateTime.now().plusDays(1), true, null);
        service.sendAlertToTopic(infoAlert, sports);

        // Mostrar alertas para Alice
        System.out.println("Alertas no leídas para Alice:");
        service.getUnreadNonExpiredAlerts(alice).forEach(alert -> System.out.println(alert.getMessage()));
    }
    }
