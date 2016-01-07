package org.icodeit.bookmarks.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="feeds")
public class Feed {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String url;
    private String title;
    private String author;
    private String summary;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date publishDate;

    @PrePersist
    protected void onCreate() {
        publishDate = new Date();
    }

    public User getUser() {
        return user;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
