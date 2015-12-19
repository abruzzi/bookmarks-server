package org.icodeit.bookmarks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    private Long id;

    private String name;
    private String email;

    @JsonIgnore
    @OneToMany
    @JoinTable(
            name="user_favorite_feed",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="feed_id", referencedColumnName="id")})
    private List<Feed> favoriteFeeds;

    public List<Feed> getFavoriteFeeds() {
        return favoriteFeeds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
