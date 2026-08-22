package com.returntosirandora.content.titles;

public class Title {
    public static enum TitleType {
        BRAWLER,
        RARE
    }

    private String title;
    private TitleType titleType;

    public Title(String title, TitleType titleType) {
        this.title = title;
        this.titleType = titleType;
    }

    public Title(String title) {
        this.title = title;
        this.titleType = TitleType.BRAWLER;
    }

    public String getTitleName() {
        return title;
    }

    public TitleType getTitleType() {
        return titleType;
    }
}
