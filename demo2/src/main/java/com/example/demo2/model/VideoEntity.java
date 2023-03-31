package com.example.demo2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Video", schema = "dbo", catalog = "Java4")
public class VideoEntity {

    public VideoEntity(String id, String title, String url, Integer views, Integer shares) {
        super();
        this.id = id;
        this.title = title;
        this.url = url;
        this.views = views;
        this.shares = shares;
    }

    public VideoEntity() {

    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;
    @Basic
    @Column(name = "title", nullable = true, length = 100)
    private String title;
    @Basic
    @Column(name = "url", nullable = true, length = 100)
    private String url;
    @Basic
    @Column(name = "views", nullable = true)
    private Integer views;
    @Basic
    @Column(name = "shares", nullable = true)
    private Integer shares;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }


}
