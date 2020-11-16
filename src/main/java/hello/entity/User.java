package hello.entity;

import java.time.Instant;

public class User {
    private final int id;
    private final String username;
    private final String avatar;
    private final Instant updateAt;
    private final Instant createdAt;

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
