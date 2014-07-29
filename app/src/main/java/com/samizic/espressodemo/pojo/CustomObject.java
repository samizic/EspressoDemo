package com.samizic.espressodemo.pojo;

public class CustomObject {

    private static final String TITLE_PREFIX = "Item #";

    private int id;
    private String title;

    public CustomObject(int id) {
        this.id = id;
        this.title = TITLE_PREFIX + id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
