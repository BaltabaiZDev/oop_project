package kz.university.model;

import java.io.Serializable;

public class News implements Serializable {
    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void publish() {
        System.out.println("News published: " + title + " - " + content);
    }
}
