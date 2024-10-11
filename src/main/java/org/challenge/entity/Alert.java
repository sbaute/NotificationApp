package org.challenge.entity;

import org.challenge.AlertType;

import java.time.LocalDateTime;

public class Alert {
    private String message;
    private AlertType type;
    private LocalDateTime expirationDate;
    private boolean isForAllUsers;
    private User specificUser;

    public Alert(String message, AlertType type, LocalDateTime expirationDate, boolean isForAllUsers, User specificUser) {
        this.message = message;
        this.type = type;
        this.expirationDate = expirationDate;
        this.isForAllUsers = isForAllUsers;
        this.specificUser = specificUser;
    }

    public String getMessage() {
        return message;
    }

    public AlertType getType() {
        return type;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public boolean isForAllUsers() {
        return isForAllUsers;
    }

    public User getSpecificUser() {
        return specificUser;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expirationDate);
    }
}