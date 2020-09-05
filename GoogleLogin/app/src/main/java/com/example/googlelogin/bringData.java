package com.example.googlelogin;

public class bringData {

    private String title;
    private String content;
    private String id;

    public bringData(){

    }

    public bringData(String title,String id,String content){
        this.title = title;
        this.id = id;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
