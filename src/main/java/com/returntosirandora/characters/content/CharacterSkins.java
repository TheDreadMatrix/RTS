package com.returntosirandora.characters.content;

import java.util.List;

import com.returntosirandora.characters.defenition.CharacterSkinDescription;
import com.returntosirandora.characters.defenition.CharacterSkinDescription.SkinCategory;
import com.returntosirandora.characters.defenition.CharacterAsset.SkinAsset;

public class CharacterSkins {

    public static final CharacterSkinDescription FRED_SKIN_0 = new CharacterSkinDescription.Builder()
            .name("Sand Man Fred")
            .cost(500)
            .categories(List.of(SkinCategory.COMMON))
            .assets(new SkinAsset("atlas/skins/killers/sand-man-fred/"))
            .build();

    // Lists
    public static final List<CharacterSkinDescription> FRED_SKINS = List.of(FRED_SKIN_0);
}
