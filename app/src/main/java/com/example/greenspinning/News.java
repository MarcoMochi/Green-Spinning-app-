package com.example.greenspinning;

public class News {
    private String title;
    private String subtitle;
    private String text;
    private int thumbnail;

    public News() {
    }

    public News(String title, String subtitle, String text, int thumbnail) {
        this.title = title;
        this.subtitle = subtitle;
        this.text = text;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setsubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getText() {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}