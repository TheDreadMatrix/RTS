package com.returntosirandora.characters.defenition;

public class AbilityDescriptior {
    private String portrait;
    private String title = "None";
    private String description = "None";

    private float coolDown = 0.0f;

    public AbilityDescriptior(String title, String description, String portrait, float coolDown) {
        this.portrait = portrait;

        this.title = title;
        this.description = description;
        this.coolDown = coolDown;
    }

    public String getPortrait() {
        return portrait;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return description;
    }

    public float getCoolDown() {
        return coolDown;
    }
}
