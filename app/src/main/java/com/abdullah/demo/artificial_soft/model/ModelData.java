package com.abdullah.demo.artificial_soft.model;

public class ModelData {

    private String id;
    private String name;
    private String who;
    private String image;
    private String user;

    public ModelData() {
    }

    public ModelData(String id, String image, String name, String user, String who) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.user = user;
        this.who = who;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "ModelData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", who='" + who + '\'' +
                ", image='" + image + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
