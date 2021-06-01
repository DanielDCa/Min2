package com.example.min2;

public class User {

    String username;
    String name;
    String avatar;
    String surname;
    Badges badges;

    public User(String username, String name, String avatar, String surname, Badges badges) {
        this.username = username;
        this.name = name;
        this.avatar = avatar;
        this.surname = surname;
        this.badges = badges;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Badges getBadges() {
        return badges;
    }

    public void setBadges(Badges badges) {
        this.badges = badges;
    }
}
