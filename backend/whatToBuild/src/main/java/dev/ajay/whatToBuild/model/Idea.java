package dev.ajay.whatToBuild.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "ideas")
public class Idea {
    @Id
    private String id;
    private String title;
    private String description;
    private int likes;
    private Set<String> likedUserIds = new HashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Set<String> getLikedUserIds() {
        return likedUserIds;
    }

    public void setLikedUserIds(Set<String> likedUserIds) {
        this.likedUserIds = likedUserIds;
    }

    public Idea(String id, String title, String description, int likes, Set<String> likedUserIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.likes = likes;
        this.likedUserIds = likedUserIds;
    }


    public Idea() {
    }
}
