package com.returntosirandora.characters.titles;

public class Title {
    public static enum TitleType {
        BRAWLER,
        RARE
    }

    String title;
    TitleType titleType;

    public Title(String title, TitleType titleType) {
        this.title = title;
        this.titleType = titleType;
    }

    public Title(String title) {
        this.title = title;
        this.titleType = TitleType.BRAWLER;
    }
}
