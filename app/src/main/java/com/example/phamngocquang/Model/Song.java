package com.example.phamngocquang.Model;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String nameSong;
    private String nameAuthor;
    public boolean isLike ;

    public Song(int id, String nameSong, String nameAuthor, boolean isLike) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameAuthor = nameAuthor;
        this.isLike = isLike;
    }

    public Song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", nameSong='" + nameSong + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", isLike=" + isLike +
                '}';
    }
}
