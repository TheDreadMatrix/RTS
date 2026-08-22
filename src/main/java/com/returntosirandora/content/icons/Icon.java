package com.returntosirandora.content.icons;

public class Icon {
    private String iconName;
    private String iconPath;
    private boolean isExclusive;

    public Icon(String iconName, String iconPath) {
        this.iconName = iconName;
        this.iconPath = iconPath;
    }

    public Icon(String iconName, String iconPath, Boolean isExclusive) {
        this.iconName = iconName;
        this.iconPath = iconPath;
        this.isExclusive = isExclusive;
    }

    public String getName() {
        return iconName;
    }

    public String getPath() {
        return iconPath;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

}
