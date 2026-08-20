package com.returntosirandora.characters.defenition;

import java.util.ArrayList;
import java.util.List;

import com.returntosirandora.characters.defenition.CharacterAsset.SkinAsset;

public class CharacterSkinDescription {

    public static enum SkinCategory {
        COMMON("Common"),
        RARE("Rare"),
        EPIC("Epic");

        private String skinName;

        SkinCategory(String skinName) {
            this.skinName = skinName;
        }

        public String getDisplayName() {
            return skinName;
        }

    }

    private String chrSkinName;
    private int chrSkinCost;

    private Boolean isExclusive = false;

    private List<SkinCategory> chrSkinCategories;
    private SkinAsset chrSkinAsset;

    public CharacterSkinDescription(Builder builder) {
        this.chrSkinName = builder.chrSkinName;
        this.chrSkinCost = builder.chrSkinCost;
        this.isExclusive = builder.isExclusive;

        this.chrSkinCategories = builder.chrSkinCategories;
        this.chrSkinAsset = builder.chrSkinAsset;
    }

    public String getSkinName() {
        return chrSkinName;
    }

    public int getSkinCost() {
        return chrSkinCost;
    }

    public Boolean IsExclusive() {
        return isExclusive;
    }

    public List<SkinCategory> getCategories() {
        return chrSkinCategories;
    }

    public SkinAsset getAsset() {
        return chrSkinAsset;
    }

    public static class Builder {
        private String chrSkinName;
        private int chrSkinCost;

        private Boolean isExclusive = false;

        private List<SkinCategory> chrSkinCategories = new ArrayList<>();
        private SkinAsset chrSkinAsset;

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

        public Builder assets(SkinAsset asset) {
            this.chrSkinAsset = asset;
            return this;
        }

        public Builder categories(List<SkinCategory> chrSkinCategories) {
            this.chrSkinCategories.addAll(chrSkinCategories);
            return this;
        }

        public Builder categories(SkinCategory chrSkinCategory) {
            this.chrSkinCategories.add(chrSkinCategory);
            return this;
        }

        public CharacterSkinDescription build() {
            return new CharacterSkinDescription(this);
        }

    }

}
