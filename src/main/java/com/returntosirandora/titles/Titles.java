package com.returntosirandora.titles;

public class Titles {
    public enum TitleType {
        BRAWLER,
        RARE
    }

    public static class Title {
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

    public static final Title TITLE_NERF_HIM = new Title("Nerf him", TitleType.RARE);
    public static final Title TITLE_DEAMON_RICHY = new Title("Daemon Richy", TitleType.RARE);
    public static final Title TITLE_DEAMON_BESTY = new Title("Daemon Besty", TitleType.RARE);
    public static final Title TITLE_RTS_2026_2027 = new Title("RTS 2026+2027", TitleType.RARE);

    public static final Title TITLE_XOR_0 = new Title("Primordial being");
    public static final Title TITLE_RAYAN_0 = new Title("False Hero");
    public static final Title TITLE_ALGOL_0 = new Title("Bloody Ruler");
    public static final Title TITLE_PROJECTILE_0 = new Title("I see you");
    public static final Title TITLE_TREVOR_0 = new Title("Rotten Grave Beast");
    public static final Title TITLE_REDIS_0 = new Title("Talanted Killer");
    public static final Title TITLE_NULLEAN_0 = new Title("Prodigal Son");
    public static final Title TITLE_ULTH_0 = new Title("Veteran");
    public static final Title TITLE_DREAD_MATRIX_0 = new Title("An imitation of hope");

}
