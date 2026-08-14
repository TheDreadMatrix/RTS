package com.returntosirandora.characters;

import java.util.List;

public class CharacterSkin {

    public static enum SkinCategory {
        COMMON,
        RARE,
        EPIC
    }

    public String chrSkinName;
    public int chrSkinCost;

    public Boolean isExclusive = false;

    public List<SkinCategory> chrSkinCategories;

    public CharacterSkin(Builder builder) {
        this.chrSkinName = builder.chrSkinName;
        this.chrSkinCost = builder.chrSkinCost;
        this.isExclusive = builder.isExclusive;

        this.chrSkinCategories = builder.chrSkinCategories;
    }

    public static class Builder {
        private String chrSkinName;
        private int chrSkinCost;

        private Boolean isExclusive = false;

        private List<SkinCategory> chrSkinCategories;

        public Builder name(String chrSkinName) {
            this.chrSkinName = chrSkinName;
            return this;
        }

        public Builder cost(int chrSkinCost) {
            this.chrSkinCost = chrSkinCost;
            return this;
        }

        public Builder exclusive(boolean isExclusive) {
            this.isExclusive = isExclusive;
            return this;
        }

        public Builder categories(List<SkinCategory> chrSkinCategories) {
            this.chrSkinCategories = chrSkinCategories;
            return this;
        }

        public CharacterSkin build() {
            return new CharacterSkin(this);
        }

    }

}
