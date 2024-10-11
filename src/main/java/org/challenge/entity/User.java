package org.challenge.entity;

import org.challenge.entity.Alert;
import org.challenge.entity.Topic;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private Set<Topic> subscribedTopics;
    private Set<Alert> alerts;

    public User(String name) {
        this.name = name;
        this.subscribedTopics = new HashSet<>();
        this.alerts = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Topic> getSubscribedTopics() {
        return subscribedTopics;
    }

    public Set<Alert> getAlerts() {
        return alerts;
    }

    public void addAlert(Alert alert) {
        alerts.add(alert);
    }

    public void subscribeToTopic(Topic topic) {
        subscribedTopics.add(topic);
    }
}