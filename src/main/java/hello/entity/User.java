package hello.entity;

import java.time.Instant;

public class User {
    private int id;
    private String username;
    private String avatar;
    private Instant updateAt;
    private Instant createdAt;

    public User(int id, String username, String avatar, Instant updateAt, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.updateAt = updateAt;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
